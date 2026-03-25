package com.effortcure.service.implementation;

import com.effortcure.api.AuthApi;
import com.effortcure.dto.request.LoginRequestDTO;
import com.effortcure.dto.request.RegisterRequestDTO;
import com.effortcure.dto.request.VerifyEmailRequestDTO;
import com.effortcure.dto.response.ApiResponse;
import com.effortcure.dto.response.LoginResponseDTO;
import com.effortcure.service.interfaces.AuthServiceInterface;

public class AuthService implements AuthServiceInterface {

    private final AuthApi authApi = new AuthApi();

    @Override
    public ApiResponse<Void> checkEmailExistance(String email) throws Exception {
        RegisterRequestDTO registerRequestDTO = new RegisterRequestDTO();
        registerRequestDTO.setEmail(email);
        return authApi.checkEmailExistance(registerRequestDTO);
    }

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

    @Override
    public ApiResponse<Void> verifyEmail(String email, String code) throws Exception {
        VerifyEmailRequestDTO verifyEmailRequestDTO = new VerifyEmailRequestDTO();
        verifyEmailRequestDTO.setEmail(email);
        verifyEmailRequestDTO.setCode(code);
        return authApi.verifyEmail(verifyEmailRequestDTO);
    }

    @Override
    public ApiResponse<LoginResponseDTO> login(String email, String password) throws Exception {
        LoginRequestDTO loginRequestDTO = new LoginRequestDTO();
        loginRequestDTO.setEmail(email);
        loginRequestDTO.setPassword(password);
        return authApi.login(loginRequestDTO);
    }
}
