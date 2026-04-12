package com.effortcure.service.implementation;

import com.effortcure.api.AuthApi;
import com.effortcure.auth.AccessTokenManager;
import com.effortcure.auth.RefreshTokenManager;
import com.effortcure.dto.request.LoginRequestDTO;
import com.effortcure.dto.request.RegisterRequestDTO;
import com.effortcure.dto.request.VerifyEmailRequestDTO;
import com.effortcure.dto.response.ApiResponse;
import com.effortcure.dto.response.LoginResponseDTO;
import com.effortcure.navigator.SceneManager;
import com.effortcure.service.interfaces.AuthServiceInterface;

public class AuthService implements AuthServiceInterface {

    private final AuthApi authApi = new AuthApi();

    @Override
    public ApiResponse<Void> checkEmailExistance(String email) throws Exception {
        return authApi.checkEmailExistance(email);
    }

    @Override
    public ApiResponse<LoginResponseDTO> verifyEmail(String email, String code) throws Exception {
        VerifyEmailRequestDTO verifyEmailRequestDTO = new VerifyEmailRequestDTO();
        verifyEmailRequestDTO.setEmail(email);
        verifyEmailRequestDTO.setCode(code);
        ApiResponse<LoginResponseDTO> response = authApi.verifyEmail(verifyEmailRequestDTO);
        if (response.getData() != null) {
            AccessTokenManager.getInstance().setAccessToken(response.getData().getAccessToken());
        }
        return response;
    }

    @Override
    public ApiResponse<LoginResponseDTO> login(String email, String password) throws Exception {
        LoginRequestDTO loginRequestDTO = new LoginRequestDTO();
        loginRequestDTO.setEmail(email);
        loginRequestDTO.setPassword(password);
        ApiResponse<LoginResponseDTO> response = authApi.login(loginRequestDTO);
        if (response.getData() != null)
            AccessTokenManager.getInstance().setAccessToken(response.getData().getAccessToken());
        return response;
    }

    @Override
    public void resendCode(String email) throws Exception {
        authApi.resendCode(email);
    }

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
    public void deleteUnverifiedAccount(String email) throws Exception {
        authApi.deleteUnverifiedAccount(email);
    }

    @Override
    public ApiResponse<Void> forgotPassword(String email) throws Exception {
        return authApi.forgotPassword(email);
    }

    @Override
    public void logout() throws Exception {
        authApi.logout();
        RefreshTokenManager.deleteRefreshToken();
        AccessTokenManager.getInstance().clearAccessToken();
    }

    @Override
    public void refreshAccessAndRefreshTokens() throws Exception {
        ApiResponse<LoginResponseDTO> response = authApi.refreshAccessAndRefreshTokens();
        if (response.getData() != null)
            AccessTokenManager.getInstance().setAccessToken(response.getData().getAccessToken());
        if (response.getStatus() != 200) {
            SceneManager.switchScene("/fxml/login-page.fxml");
            logout();
        }
    }

}
