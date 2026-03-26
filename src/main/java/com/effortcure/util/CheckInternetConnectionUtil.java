package com.effortcure.util;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CheckInternetConnectionUtil {
    public static boolean isInternetAvailable() {
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://www.google.com"))
                    .method("HEAD", HttpRequest.BodyPublishers.noBody())
                    .timeout(java.time.Duration.ofSeconds(2))
                    .build();

            HttpResponse<Void> response = client.send(request, HttpResponse.BodyHandlers.discarding());

            return response.statusCode() >= 200 && response.statusCode() < 400;

        } catch (Exception e) {
            return false;
        }
    }
}
