package IT.Nico.TelBot.service;

import IT.Nico.TelBot.model.CurrencyModel;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class CurrencyService {

    public static String getCurrencyRate(String message, CurrencyModel model) throws IOException, ParseException {
        URL url = new URL("https://api.frankfurter.app/latest" + message + "?amount=100&from=EUR&to=USD");
        Scanner scanner = new Scanner((InputStream) url.getContent());
        String result = "";
        while (scanner.hasNext()){
            result +=scanner.nextLine();
        }
        JSONObject object = new JSONObject(result);

        model.setCur_ID(object.getInt("Cur_ID"));
        model.setDate(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(object.getString("Date")));
        model.setCur_Abbreviation(object.getString("Cur_Abbreviation"));
        model.setCur_Scale(object.getInt("Cur_Scale"));
        model.setCur_Name(object.getString("Cur_Name"));
        model.setCur_TelBot(object.getDouble("Cur_OfficialRate"));


        return "Official rate of BYN to " + model.getCur_Abbreviation() + "\n" +
                "on the date: " + getFormatDate(model) + "\n" +
                "is: " + model.getCur_TelBot() + " BYN per " + model.getCur_Scale() + " " + model.getCur_Abbreviation();

    }

    private static String getFormatDate(CurrencyModel model) {
        return new SimpleDateFormat("dd MMM yyyy").format(model.getDate());
    }
}