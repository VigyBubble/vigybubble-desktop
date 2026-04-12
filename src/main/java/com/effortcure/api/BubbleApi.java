package com.effortcure.api;

import java.net.http.HttpResponse;
import java.util.UUID;

import com.effortcure.dto.request.CreateBubbleRequestDTO;
import com.effortcure.util.ApiClientUtil;
import com.effortcure.util.JsonUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.effortcure.dto.response.ApiResponse;
import com.effortcure.dto.request.ModifyBubbleNameRequestDTO;

public class BubbleApi {

    private final String BASE_URL = "http://localhost:9090//api/v1/bubbles/";

    public ApiResponse<Void> createBubble(CreateBubbleRequestDTO createBubbleRequestDTO) throws Exception {
        HttpResponse<String> response = ApiClientUtil.post(BASE_URL, JsonUtil.toJson(createBubbleRequestDTO), null,
                null);
        return JsonUtil.fromJson(response.body(), new TypeReference<ApiResponse<Void>>() {
        });
    }

    public ApiResponse<Void> modifyBubbleName(UUID bubbleUuid, ModifyBubbleNameRequestDTO modifyBubbleNameRequestDTO)
            throws Exception {
        HttpResponse<String> response = ApiClientUtil.patch(BASE_URL + bubbleUuid + "/name",
                JsonUtil.toJson(modifyBubbleNameRequestDTO), null,
                null);
        return JsonUtil.fromJson(response.body(), new TypeReference<ApiResponse<Void>>() {
        });
    }

    public ApiResponse<Void> modifyBubbleDirectories(UUID bubbleUuid, ModifyBubbleNameRequestDTO modifyBubbleDirectoriesRequestDTO)
            throws Exception {
        HttpResponse<String> response = ApiClientUtil.patch(BASE_URL + bubbleUuid + "/directories-list",
                JsonUtil.toJson(modifyBubbleDirectoriesRequestDTO), null,
                null);
        return JsonUtil.fromJson(response.body(), new TypeReference<ApiResponse<Void>>() {
        });
    }

}
