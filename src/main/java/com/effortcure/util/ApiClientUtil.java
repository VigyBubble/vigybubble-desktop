package com.effortcure.util;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiClientUtil {
        private static final HttpClient client = HttpClient.newHttpClient();

        public static HttpResponse<String> post(String url, String json, String accessToken, String refreshToken)
                        throws Exception {
                HttpRequest.Builder builder = HttpRequest.newBuilder()
                                .uri(new URI(url))
                                .header("Content-Type", "application/json")
                                .header("Accept", "application/json")
                                .headers("User-Agent",
                                                "JavaFxApp: OS-" + System.getProperty("os.name") + " OS-VERSION-"
                                                                + System.getProperty("os.version") + " ARCH-"
                                                                + System.getProperty("os.arch"));
                if (accessToken != null) {
                        builder.header("Authorization", "Bearer " + accessToken);
                }
                if (refreshToken != null) {
                        builder.header("Cookie", "refresh-token=" + refreshToken);
                }

                HttpRequest request = builder.POST(HttpRequest.BodyPublishers.ofString(json)).build();
                return client.send(request, HttpResponse.BodyHandlers.ofString());
        }
}
