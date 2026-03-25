package com.effortcure.service.interfaces;

import com.effortcure.dto.response.ApiResponse;
import com.effortcure.dto.response.LoginResponseDTO;

public interface AuthServiceInterface {
    public ApiResponse<Void> checkEmailExistance(String email) throws Exception;

    public ApiResponse<Void> register(String name, String email, String password, String confirmPassword)
            throws Exception;

    public ApiResponse<Void> verifyEmail(String email, String code) throws Exception;

    public ApiResponse<LoginResponseDTO> login(String email, String password) throws Exception;
}
