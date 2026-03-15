package com.effortcure.api;

import java.net.http.HttpResponse;

import com.effortcure.dto.request.RegisterRequestDTO;
import com.effortcure.dto.response.ApiResponse;
import com.effortcure.exception.ApiException;
import com.effortcure.util.ApiClientUtil;
import com.effortcure.util.JsonUtil;
import com.fasterxml.jackson.core.type.TypeReference;

public class AuthApi {
    private final String BASE_URL = "http://localhost:9090/api/v1/auth/";

    public ApiResponse<Void> register(RegisterRequestDTO registerRequestDTO) throws Exception {

        HttpResponse<String> response = ApiClientUtil.post(BASE_URL + "register", JsonUtil.toJson(registerRequestDTO));

        if (response.statusCode() == 201) {
            return JsonUtil.fromJson(response.body(), new TypeReference<ApiResponse<Void>>() {
            });
        }
        throw new ApiException(response.body());
    }
}
