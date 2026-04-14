package com.effortcure.api;

import java.net.http.HttpResponse;

import com.effortcure.auth.AccessTokenManager;
import com.effortcure.dto.request.ChangePasswordRequestDTO;
import com.effortcure.dto.response.ApiResponse;
import com.effortcure.dto.response.BreifAccountInfoResponseDTO;
import com.effortcure.util.ApiClientUtil;
import com.effortcure.util.JsonUtil;
import com.fasterxml.jackson.core.type.TypeReference;

public class AccountApi {
    private final String BASE_URL = "http://localhost:9090/api/v1/accounts/";

    public ApiResponse<Void> changePassword(ChangePasswordRequestDTO changePasswordRequestDTO) throws Exception {
        HttpResponse<String> response = ApiClientUtil.post(BASE_URL + "change-password",
                JsonUtil.toJson(changePasswordRequestDTO), AccessTokenManager.getInstance().getAccessToken(), null);
        if (response.statusCode() == 403)
            return null;
        return JsonUtil.fromJson(response.body(), new TypeReference<ApiResponse<Void>>() {
        });
    }

    public ApiResponse<BreifAccountInfoResponseDTO> getBreifAccountInfo() throws Exception {
        HttpResponse<String> response = ApiClientUtil.get(BASE_URL + "profile-breif", null,
                AccessTokenManager.getInstance().getAccessToken(), null);
        if (response.statusCode() == 403)
            return null;
        return JsonUtil.fromJson(response.body(), new TypeReference<ApiResponse<BreifAccountInfoResponseDTO>>() {
        });
    }
}
