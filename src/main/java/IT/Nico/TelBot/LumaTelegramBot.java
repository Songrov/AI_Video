package IT.Nico.TelBot;
/*
import IT.Nico.TelBot.model.CurrencyModel;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import okhttp3.*;

import java.io.IOException;
import java.text.ParseException;

import static jdk.javadoc.internal.tool.Main.execute;

public class LumaTelegramBot extends TelegramApiException {

    private final String botToken = "<7815802972:AAHnNPIXRgSZbgxcRmJ4M4qAuIF4NRyEoiI";
    private final String botUsername = "IT_Nico_bot";
    private final String lumaApiUrl = "https://api.lumalabs.ai/dream-machine/v1/generations";
    private final String lumaApiKey = "luma-a25f4e10-8952-4f54-b75c-651fd6c2eb7b-c51e0790-9fd2-4e22-91d2-d32e9f283aaa";

  /*  @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        if (message != null && message.hasText()) {
            String text = message.getText();
            if (text.equalsIgnoreCase("/s")) {
                sendMessage(message.getChatId(), "Привет! Я помогу тебе создать 3D-модели.");
            } else {
                // Отправить запрос в Luma API
                String model = generate3DModel();
                sendMessage(message.getChatId(), "Генерация завершена! Модель: " + model);
            }
        }
    }



import java.io.IOException;

@Override
    public void onUpdateReceived(Update update) {
        CurrencyModel currencyModel = new CurrencyModel();
        String currency = "";

        if(update.hasMessage() && update.getMessage().hasText()){
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            switch (messageText){
                case "/s":
                    startCommandReceived(chatId, update.getMessage().getChat().getFirstName());
                    break;
                default:
                    try {

                        currency = CurrencyService.getCurrencyRate(messageText, currencyModel);

                    } catch (IOException e) {
                        sendMessage(chatId, "We have not found such a currency." + "\n" +
                                "Enter the currency whose official exchange rate" + "\n" +
                                "you want to know in relation to RUB." + "\n" +
                                "For example: EUR");
                    } catch (ParseException e) {
                        throw new RuntimeException("Unable to parse date");
                    }
                    sendMessage(chatId, currency);
            }
        }

    }



    private void startCommandReceived(Long chatId, String name) {
        String answer = "Привет, " + name + ", nice to meet you!" + "\n" +
                "Enter the currency whose official exchange rate" + "\n" +
                "you want to know in relation to RUB." + "\n" +
                "For example: EUR";
        sendMessage(chatId, answer);
    }



    private void sendMessage(Long chatId, String textToSend){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(chatId));
        sendMessage.setText(textToSend);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {

        }
    }










    private String generate3DModel() {
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(
                MediaType.parse("application/json"),
                "{ \"prompt\": \"3D model of a futuristic car\", \"num_images\": 1 }"
        );
        Request request = new Request.Builder()
                .url(lumaApiUrl)
                .addHeader("Authorization", "Bearer " + lumaApiKey)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                return response.body().string(); // Примерная обработка ответа
            } else {
                return "Ошибка генерации модели.";
            }
        } catch (IOException e) {
            return "Ошибка соединения с Luma API.";
        }
    }

    private void sendMessage(Long chatId, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(text);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }
}


*/