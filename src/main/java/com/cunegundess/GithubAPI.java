package com.cunegundess;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;


public class GithubAPI {
    private static final String API_URL = "https://api.github.com/users/%s/events";

    public static void fetchAPI(String username) {
        try {
            String apiUrl = String.format(API_URL, username);
            URL url = new URI(apiUrl).toURL();

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            int responseCode = connection.getResponseCode();

            if (responseCode != 200) {
                System.out.println("Unable to fetch data. HTTP response code: " + responseCode);
                return;
            }

            String content;
            try (InputStream inputStream = connection.getInputStream()) {
                content = new String(inputStream.readAllBytes());
            }

            JsonArray events = JsonParser.parseString(content).getAsJsonArray();

            if (events.isEmpty()) {
                System.out.println("No recent activity found for user: " + username);
                return;
            }

            System.out.println(DisplayCLI.formatAllEvents(events));

        }
        catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }
}
