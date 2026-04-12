package com.effortcure.api;

import java.net.http.HttpResponse;
import com.effortcure.dto.request.CreateBubbleRequestDTO;
import com.effortcure.util.ApiClientUtil;
import com.effortcure.util.JsonUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.effortcure.dto.response.ApiResponse;

public class BubbleApi {

    private final String BASE_URL = "http://localhost:9090//api/v1/bubbles/";

    public ApiResponse<Void> createBubble(CreateBubbleRequestDTO createBubbleRequestDTO) throws Exception {
        HttpResponse<String> response = ApiClientUtil.post(BASE_URL, JsonUtil.toJson(createBubbleRequestDTO), null,
                null);
        return JsonUtil.fromJson(response.body(), new TypeReference<ApiResponse<Void>>() {
        });
    }
}
