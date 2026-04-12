package com.effortcure.api;

import java.net.http.HttpResponse;

import com.effortcure.auth.RefreshTokenManager;
import com.effortcure.dto.request.LoginRequestDTO;
import com.effortcure.dto.request.RegisterRequestDTO;
import com.effortcure.dto.request.VerifyEmailRequestDTO;
import com.effortcure.dto.response.ApiResponse;
import com.effortcure.dto.response.LoginResponseDTO;
import com.effortcure.util.ApiClientUtil;
import com.effortcure.util.JsonUtil;
import com.fasterxml.jackson.core.type.TypeReference;



public class AuthApi {
    private final String BASE_URL = "http://localhost:9090/api/v1/auth";


    public ApiResponse<Void> checkEmailExistance(String email) throws Exception {
        HttpResponse<String> response = ApiClientUtil.get(BASE_URL + "/email-exists/" + email, null, null, null);
        return JsonUtil.fromJson(response.body(), new TypeReference<ApiResponse<Void>>() {
        });
    }

    public ApiResponse<Void> register(RegisterRequestDTO registerRequestDTO) throws Exception {
        HttpResponse<String> response = ApiClientUtil.post(BASE_URL + "/register", JsonUtil.toJson(registerRequestDTO),
                null, null);
        return JsonUtil.fromJson(response.body(), new TypeReference<ApiResponse<Void>>() {
        });
    }

    public ApiResponse<LoginResponseDTO> verifyEmail(VerifyEmailRequestDTO verifyEmailRequestDTO) throws Exception {
        HttpResponse<String> response = ApiClientUtil.post(BASE_URL + "/verify-email",
                JsonUtil.toJson(verifyEmailRequestDTO), null, null);
        if (response.statusCode() == 200) {
            RefreshTokenManager.saveRefreshToken(ApiClientUtil.extractRefreshToken(response));
        }
        return JsonUtil.fromJson(response.body(), new TypeReference<ApiResponse<LoginResponseDTO>>() {
        });
    }

    public ApiResponse<LoginResponseDTO> login(LoginRequestDTO loginRequestDTO) throws Exception {
        HttpResponse<String> response = ApiClientUtil.post(BASE_URL + "/login", JsonUtil.toJson(loginRequestDTO), null,
                null);
        if (response.statusCode() == 200) {
            RefreshTokenManager.saveRefreshToken(ApiClientUtil.extractRefreshToken(response));
        }
        return JsonUtil.fromJson(response.body(), new TypeReference<ApiResponse<LoginResponseDTO>>() {
        });
    }

    public void resendCode(String email) throws Exception {
        ApiClientUtil.post(BASE_URL + "/resend-code/" + email, null, null, null);
    }

    public void deleteUnverifiedAccount(String email) throws Exception {
        ApiClientUtil.delete(BASE_URL + "/remove-unverified-account/" + email, null, null, null);
    }

}
