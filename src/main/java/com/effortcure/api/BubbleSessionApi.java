package com.effortcure.api;

import java.net.http.HttpResponse;
import java.util.Set;
import java.util.UUID;

import com.effortcure.auth.AccessTokenManager;
import com.effortcure.dto.request.CreateSessionRequestDTO;
import com.effortcure.dto.response.ApiResponse;
import com.effortcure.dto.response.BubbleSessionsResponseDTO;
import com.effortcure.util.ApiClientUtil;
import com.effortcure.util.JsonUtil;
import com.fasterxml.jackson.core.type.TypeReference;

public class BubbleSessionApi {
    
    private final String BASE_URL = "http://localhost:9090/api/v1/bubbles/";


 public ApiResponse<Set<BubbleSessionsResponseDTO>> getBubbleSession(UUID bubbleUuid) throws Exception {

       HttpResponse<String> response = ApiClientUtil.get(BASE_URL + bubbleUuid + "/sessions/", null,
                AccessTokenManager.getInstance().getAccessToken(),
                null);
        if (response.statusCode() == 403)
            return null;
        return JsonUtil.fromJson(response.body(), new TypeReference<ApiResponse<Set<BubbleSessionsResponseDTO>>>() {
        });
    }


    public ApiResponse<Void> createSession(UUID bubbleUuid,CreateSessionRequestDTO createSessionRequestDTO) throws Exception {
        HttpResponse<String> response = ApiClientUtil.post(BASE_URL + bubbleUuid + "/sessions/", JsonUtil.toJson(createSessionRequestDTO),
                AccessTokenManager.getInstance().getAccessToken(),
                null);
        if (response.statusCode() == 403)
            return null;
        return JsonUtil.fromJson(response.body(), new TypeReference<ApiResponse<Void>>() {
        });
    }




}
