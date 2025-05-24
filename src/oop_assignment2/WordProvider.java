package oop_assignment2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WordProvider {
    private static final String API_URL = "https://random-word-api.herokuapp.com/word";

    public static String fetchRandomWord() {
        String word = "";
        try {
            URL url = new URL(API_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int status = connection.getResponseCode();

            if (status == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                word = in.readLine();
                in.close();

                // Remove [ and ] from string (first and last character)
                if (word.length() > 2) {
                    word = word.substring(1, word.length() - 1); // remove brackets
                }

                // Remove quotes
                word = word.replace("\"", "");
            } else {
                System.out.println("API returned status: " + status);
                word = "default";
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
            word = "default";
        }
        return word.toLowerCase();
    }
}

