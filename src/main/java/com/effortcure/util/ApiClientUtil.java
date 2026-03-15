package com.effortcure.util;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiClientUtil {
    private static final HttpClient client = HttpClient.newHttpClient();

    public static HttpResponse<String> post(String url, String json, String accessToken, String refreshToken)
            throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .header("content-type", "application/json")
                .header("Accept", "application/json")
                .headers("User-Agent",
                        "JavaFxApp: OS-" + System.getProperty("os.name") + " OS-VERSION-"
                                + System.getProperty("os.version") + " ARCH-" + System.getProperty("os.arch"))
                .header("Authorization", (accessToken == null) ? null : "Bearer " + accessToken)
                .header("Set-Cookie", (refreshToken == null) ? null : "refresh-token=" + refreshToken)
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
