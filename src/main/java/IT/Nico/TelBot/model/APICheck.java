package IT.Nico.TelBot.model;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class APICheck {
    public static void main(String[] args) {
        try {
            String apiUrl = "https://api.lumalabs.ai/dream-machine/v1/generations";
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Authorization", "Bearer luma-a25f4e10-8952-4f54-b75c-651fd6c2eb7b-c51e0790-9fd2-4e22-91d2-d32e9f283aaa");

            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                System.out.println("API is working!");
            } else {
                System.out.println("Error: " + responseCode);
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println(response.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


