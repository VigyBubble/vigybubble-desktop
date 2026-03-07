package com.effortcure.service.interfaces;

import com.effortcure.dto.response.ApiResponse;

public interface AuthServiceInterface {
    public ApiResponse<Void> register(String name, String email, String password, String confirmPassword)
            throws Exception;
}
