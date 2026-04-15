package com.effortcure.api;

import java.net.http.HttpResponse;
import java.util.UUID;

import com.effortcure.auth.AccessTokenManager;
import com.effortcure.dto.request.CreateBubbleRequestDTO;
import com.effortcure.util.ApiClientUtil;
import com.effortcure.util.JsonUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.effortcure.dto.response.ApiResponse;
import com.effortcure.dto.response.GetBubbleResponseDTO;
import com.effortcure.dto.request.ModifyBubbleRequestDTO;
import com.effortcure.enums.ModifyBubbleType;

public class BubbleApi {

    private final String BASE_URL = "http://localhost:9090//api/v1/bubbles/";

    public ApiResponse<Void> createBubble(CreateBubbleRequestDTO createBubbleRequestDTO) throws Exception {
        HttpResponse<String> response = ApiClientUtil.post(BASE_URL, JsonUtil.toJson(createBubbleRequestDTO),
                AccessTokenManager.getInstance().getAccessToken(),
                null);

        if (response.statusCode() == 403)
            return null;
        return JsonUtil.fromJson(response.body(), new TypeReference<ApiResponse<Void>>() {
        });
    }

    public ApiResponse<Void> modifyBubble(UUID bubbleUuid, ModifyBubbleRequestDTO modifyBubbleRequestDTO,
            ModifyBubbleType type)
            throws Exception {
        String url = BASE_URL + bubbleUuid;
        if (type == ModifyBubbleType.NAME) {
            url += "/name";
        } else if (type == ModifyBubbleType.DESCRIPTION) {
            url += "/description";
        } else if (type == ModifyBubbleType.APPLICATIONS_LIST) {
            url += "/applications-list";
        } else if (type == ModifyBubbleType.DIRECTORIES_LIST) {
            url += "/directories-list";
        }
        HttpResponse<String> response = ApiClientUtil.patch(url,
                JsonUtil.toJson(modifyBubbleRequestDTO), AccessTokenManager.getInstance().getAccessToken(),
                null);
        if (response.statusCode() == 403)
            return null;
        return JsonUtil.fromJson(response.body(), new TypeReference<ApiResponse<Void>>() {
        });

    }

    public ApiResponse<Void> deleteBubble(UUID bubbleUuid) throws Exception {
         HttpResponse<String> response = ApiClientUtil.delete(BASE_URL + bubbleUuid, null, AccessTokenManager.getInstance().getAccessToken(), null);
         if (response.statusCode() == 403)
            return null;
        return JsonUtil.fromJson(response.body(), new TypeReference<ApiResponse<Void>>() {
        });
    }

    public ApiResponse<GetBubbleResponseDTO> getBubbleDetails(UUID bubbleUuid) throws Exception {
        HttpResponse<String> response = ApiClientUtil.get(BASE_URL + bubbleUuid, null,
                AccessTokenManager.getInstance().getAccessToken(), null);
        if (response.statusCode() == 403)
            return null;
        return JsonUtil.fromJson(response.body(), new TypeReference<ApiResponse<GetBubbleResponseDTO>>() {
        });
    }

    public ApiResponse<GetBubbleResponseDTO> getAccountBubbles() throws Exception {
        HttpResponse<String> response = ApiClientUtil.get(BASE_URL, null,
                AccessTokenManager.getInstance().getAccessToken(), null);
        if (response.statusCode() == 403)
            return null;
        return JsonUtil.fromJson(response.body(), new TypeReference<ApiResponse<GetBubbleResponseDTO>>() {
        });
    }

}
