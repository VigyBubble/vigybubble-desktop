package com.effortcure.api;

import java.net.http.HttpResponse;
import java.util.UUID;

import com.effortcure.dto.request.CreateBubbleRequestDTO;
import com.effortcure.util.ApiClientUtil;
import com.effortcure.util.JsonUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.effortcure.dto.response.ApiResponse;
import com.effortcure.dto.request.ModifyBubbleRequestDTO;
public class BubbleApi {

    private final String BASE_URL = "http://localhost:9090//api/v1/bubbles/";

    public ApiResponse<Void> createBubble(CreateBubbleRequestDTO createBubbleRequestDTO) throws Exception {
        HttpResponse<String> response = ApiClientUtil.post(BASE_URL, JsonUtil.toJson(createBubbleRequestDTO), null,
                null);
        return JsonUtil.fromJson(response.body(), new TypeReference<ApiResponse<Void>>() {
        });
    }

    public ApiResponse<Void> modifyBubbleName(UUID bubbleUuid, ModifyBubbleRequestDTO modifyBubbleRequestDTO)
            throws Exception {
        HttpResponse<String> response = ApiClientUtil.patch(BASE_URL + bubbleUuid + "/name",
                JsonUtil.toJson(modifyBubbleRequestDTO), null,
                null);
        return JsonUtil.fromJson(response.body(), new TypeReference<ApiResponse<Void>>() {
        });
    }

    public ApiResponse<Void> modifyBubbleDirectories(UUID bubbleUuid, ModifyBubbleRequestDTO modifyBubbleRequestDTO)
            throws Exception {
        HttpResponse<String> response = ApiClientUtil.patch(BASE_URL + bubbleUuid + "/directories-list",
                JsonUtil.toJson(modifyBubbleRequestDTO), null,
                null);
        return JsonUtil.fromJson(response.body(), new TypeReference<ApiResponse<Void>>() {
        });
    }


      public ApiResponse<Void> modifyBubbleDescription(UUID bubbleUuid, ModifyBubbleRequestDTO modifyBubbleRequestDTO)
            throws Exception {
        HttpResponse<String> response = ApiClientUtil.patch(BASE_URL + bubbleUuid + "/description",
                JsonUtil.toJson(modifyBubbleRequestDTO), null,
                null);
        return JsonUtil.fromJson(response.body(), new TypeReference<ApiResponse<Void>>() {
        });
    }


}
