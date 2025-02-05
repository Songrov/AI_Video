package IT.Nico.TelBot;


import IT.Nico.TelBot.model.CurrencyModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.springframework.stereotype.Component;

@Component
public class MyTelegramBot extends TelegramLongPollingBot {

    @Autowired
    private LumaAiService lumaAiService;




    private  BotConfig botConfig;


   @Override
    public String getBotUsername() {
        return "IT_Nico_bot";
    }


    @Override
   public String getBotToken() {
        return "7815802972:AAHnNPIXRgSZbgxcRmJ4M4qAuIF4NRyEoiI";
   }

// luma-481dc24a-8f63-41b6-9dd8-bf0cebc55a27-cba679e9-7d43-4b01-8a93-e61e54056d04

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            if (messageText.startsWith("/video")) {
                String prompt = messageText.replace("/vidoe", "").trim();
                if (prompt.isEmpty()) {
                    sendMessage(chatId, "Введите описание модели после команды /generate3d.");
                    return;
                }

                sendMessage(chatId, "Генерирую 3D-модель... Подождите ⏳");

                // Запрос к Luma AI API
                String response = lumaAiService.generate3DModel(prompt);

                sendMessage(chatId, "Ваша 3D-модель: " + response);
            }
        }
    }


    private void sendMessage(long chatId, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(text);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}


