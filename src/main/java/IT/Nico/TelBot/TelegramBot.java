package IT.Nico.TelBot;
/*
import IT.Nico.TelBot.model.CurrencyModel;
import IT.Nico.TelBot.service.CurrencyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;
import java.text.ParseException;

@Service
@AllArgsConstructor
public class TelegramBot extends TelegramLongPollingBot {
    @Autowired
    TelegramBot(BotConfig botConfig){
        this.botConfig = new BotConfig();
    }
    private  BotConfig botConfig;

    @Override
    public String getBotUsername() {
        return botConfig.getBotName();
    }

    @Override
    public String getBotToken() {
        return botConfig.getToken();
    }
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
                                "you want to know in relation to RUS." + "\n" +
                                "For example: EUR");
                    } catch (ParseException e) {
                        throw new RuntimeException("Unable to parse date");
                    }
                    sendMessage(chatId, currency);
            }
        }

    }
    private void startCommandReceived(Long chatId, String name) {
        String answer = "Hi, " + name + ", nice to meet you!" + "\n" +
                "Enter the currency whose official exchange rate" + "\n" +
                "you want to know in relation to RUS." + "\n" +
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
}


*/