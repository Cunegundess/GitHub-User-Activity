package com.cunegundess;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;


public class DisplayCLI {
        public static String formatAllEvents(JsonArray events) {
        Map<String, Integer> pushEventCounts = new HashMap<>();
        StringBuilder formattedOutput = new StringBuilder();

        for (JsonElement jsonElement : events) {
            JsonObject event = jsonElement.getAsJsonObject();
            String eventType = event.get("type").getAsString();
            String repoName = event.get("repo").getAsJsonObject()
                    .get("name").getAsString();

            switch (eventType) {
                case "PushEvent" -> {
                    int commitCount = event.get("payload").getAsJsonObject()
                            .get("commits").getAsJsonArray().size();
                    pushEventCounts.put(repoName, pushEventCounts.getOrDefault(repoName, 0) + commitCount);
                    break;
                }
                case "WatchEvent" -> {
                    formattedOutput.append("Starred ").append(repoName).append("\n");
                    break;
                }
                case "ForkEvent" -> {
                    formattedOutput.append("Forked ").append(repoName).append("\n");
                    break;
                }
                case "PullRequestEvent" -> {
                    formattedOutput.append("Pull Requested ").append(repoName).append("\n");
                    break;
                }
                case "IssueEvent" -> {
                    formattedOutput.append("Issued ").append(repoName).append("\n");
                    break;
                }
                case "CreateEvent" -> {
                    formattedOutput.append("Created ").append(repoName).append("\n");
                    break;
                }
                default -> {
                    formattedOutput.append(eventType).append(" ").append(eventType).append("\n");
                    break;
                }
            }
        }

        for (Map.Entry<String, Integer> entry : pushEventCounts.entrySet()) {
            formattedOutput.append("Pushed ")
                    .append(entry.getValue())
                    .append(" commmit(s) to ")
                    .append(entry.getKey())
                    .append("\n");
        }

        return formattedOutput.toString();
    }
}
