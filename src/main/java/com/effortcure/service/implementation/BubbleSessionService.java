package com.effortcure.service.implementation;

import java.util.UUID;

import com.effortcure.api.BubbleSessionApi;
import com.effortcure.dto.response.ApiResponse;
import com.effortcure.dto.response.BubbleSessionsResponseDTo;
import com.effortcure.navigator.SceneManager;
import com.effortcure.service.interfaces.AuthServiceInterface;
import com.effortcure.service.interfaces.BubbleSessionServiceInterface;

public class BubbleSessionService implements BubbleSessionServiceInterface {
    private final BubbleSessionApi bubbleSessionApi = new BubbleSessionApi();
    private AuthServiceInterface authServiceInterface = new AuthService();

    public ApiResponse<BubbleSessionsResponseDTo> getBubbleSession(UUID bubbleUuid) throws Exception {
        ApiResponse<BubbleSessionsResponseDTo> response = bubbleSessionApi.getBubbleSession(bubbleUuid);
        if (response != null) {
            if (response.getStatus() == 400) {
                authServiceInterface.refreshAccessAndRefreshTokens();
                response = bubbleSessionApi.getBubbleSession(bubbleUuid);
            }
            if (response.getStatus() == 403) {
                SceneManager.switchScene("/fxml/login-page.fxml", null);
                authServiceInterface.logout();
            }
        }
        return response;
    }

}
