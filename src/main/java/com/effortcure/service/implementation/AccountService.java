package com.effortcure.service.implementation;

import com.effortcure.api.AccountApi;
import com.effortcure.dto.request.ChangePasswordRequestDTO;
import com.effortcure.dto.response.ApiResponse;
import com.effortcure.dto.response.BreifAccountInfoResponseDTO;
import com.effortcure.navigator.SceneManager;
import com.effortcure.service.interfaces.AccountServiceInterface;
import com.effortcure.service.interfaces.AuthServiceInterface;

public class AccountService implements AccountServiceInterface {

    private final AccountApi accountApi = new AccountApi();
    private final AuthServiceInterface authServiceInterface = new AuthService();

    @Override
    public ApiResponse<Void> changePassword(String password, String confirmPassword) throws Exception {
        ChangePasswordRequestDTO changePasswordRequestDTO = new ChangePasswordRequestDTO();
        changePasswordRequestDTO.setNewPassword(password);
        changePasswordRequestDTO.setConfirmNewPassword(confirmPassword);
        ApiResponse<Void> response = accountApi.changePassword(changePasswordRequestDTO);
        if (response != null) {
            if (response.getStatus() == 400) {
                authServiceInterface.refreshAccessAndRefreshTokens();
                response = accountApi.changePassword(changePasswordRequestDTO);
            }
            if (response.getStatus() == 200) {
                authServiceInterface.logout();
            }
            if (response.getStatus() == 401) {
                SceneManager.switchScene("/fxml/login-page.fxml", null);
                authServiceInterface.logout();
            }
        } else {
            SceneManager.switchScene("/fxml/login-page.fxml", null);
            authServiceInterface.logout();
        }
        return response;
    }

    @Override
    public ApiResponse<BreifAccountInfoResponseDTO> getBreifAccountInfo() throws Exception {
        ApiResponse<BreifAccountInfoResponseDTO> response = accountApi.getBreifAccountInfo();
        if (response != null) {
            if (response.getStatus() == 400) {
                authServiceInterface.refreshAccessAndRefreshTokens();
                response = accountApi.getBreifAccountInfo();
            }
            if (response.getStatus() == 401) {
                SceneManager.switchScene("/fxml/login-page.fxml", null);
                authServiceInterface.logout();
            }
        } else {
            SceneManager.switchScene("/fxml/login-page.fxml", null);
            authServiceInterface.logout();
        }
        return response;
    }

}
