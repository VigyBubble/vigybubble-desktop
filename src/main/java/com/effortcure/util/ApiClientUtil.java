package com.effortcure.util;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiClientUtil {
    private static final HttpClient client = HttpClient.newHttpClient();

    public static HttpResponse<String> get(String url, String json, String accessToken, String refreshToken)
            throws Exception {
        HttpRequest.Builder builder = commonRequestPart(url, accessToken, refreshToken);
        HttpRequest request = builder.GET().build();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public static HttpResponse<String> post(String url, String json, String accessToken, String refreshToken)
            throws Exception {
        HttpRequest.Builder builder = commonRequestPart(url, accessToken, refreshToken);
        HttpRequest request = builder
                .POST((json != null) ? HttpRequest.BodyPublishers.ofString(json) : HttpRequest.BodyPublishers.noBody())
                .build();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public static HttpResponse<String> put(String url, String json, String accessToken, String refreshToken)
            throws Exception {
        HttpRequest.Builder builder = commonRequestPart(url, accessToken, refreshToken);
        HttpRequest request = builder
                .PUT((json != null) ? HttpRequest.BodyPublishers.ofString(json) : HttpRequest.BodyPublishers.noBody())
                .build();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public static HttpResponse<String> patch(String url, String json, String accessToken, String refreshToken)
            throws Exception {
        HttpRequest.Builder builder = commonRequestPart(url, accessToken, refreshToken);
        HttpRequest request = builder
                .method("PATCH",
                        (json != null) ? HttpRequest.BodyPublishers.ofString(json)
                                : HttpRequest.BodyPublishers.noBody())
                .build();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public static HttpResponse<String> delete(String url, String json, String accessToken, String refreshToken)
            throws Exception {
        HttpRequest.Builder builder = commonRequestPart(url, accessToken, refreshToken);
        HttpRequest request = builder.DELETE().build();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    private static HttpRequest.Builder commonRequestPart(String url, String accessToken, String refreshToken)
            throws Exception {
        HttpRequest.Builder builder = HttpRequest.newBuilder()
                .uri(new URI(url))
                .header("Content-Type", "application/json")
                .header("User-Agent",
                        "JavaFxApp/1.0 (" +
                                System.getProperty("os.name") + "; " +
                                System.getProperty("os.version") + "; " +
                                System.getProperty("os.arch") + ")");
        if (accessToken != null) {
            builder.header("Authorization", "Bearer " + accessToken);
        }
        if (refreshToken != null) {
            builder.header("Cookie", "refresh-token=" + refreshToken);
        }
        return builder;
    }
}
