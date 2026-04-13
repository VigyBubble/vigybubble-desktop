package com.effortcure.service.interfaces;

import com.effortcure.dto.response.ApiResponse;

public interface AccountServiceInterface {
    public ApiResponse<Void> changePassword(String password, String confirmPassword) throws Exception;
}
