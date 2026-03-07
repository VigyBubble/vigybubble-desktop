package com.effortcure.service.implementation;

import com.effortcure.dto.request.RegisterRequestDTO;
import com.effortcure.dto.response.ApiResponse;
import com.effortcure.network.AuthApi;
import com.effortcure.service.interfaces.AuthServiceInterface;

public class AuthService implements AuthServiceInterface {

    private final AuthApi authApi = new AuthApi();

    @Override
    public ApiResponse<Void> register(String name, String email, String password, String confirmPassword)
            throws Exception {
        RegisterRequestDTO registerRequestDTO = new RegisterRequestDTO();
        registerRequestDTO.setName(name);
        registerRequestDTO.setEmail(email);
        registerRequestDTO.setPassword(password);
        registerRequestDTO.setConfirmPassword(confirmPassword);
        return authApi.register(registerRequestDTO);
    }

}
