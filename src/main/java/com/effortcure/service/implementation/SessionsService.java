package com.effortcure.service.implementation;

import java.util.Set;
import java.util.UUID;

import com.effortcure.api.SessionApi;
import com.effortcure.dto.response.ApiResponse;
import com.effortcure.dto.response.LoggedNotificationResponseDTO;
import com.effortcure.dto.response.PerformanceMetricsResponseDTO;
import com.effortcure.dto.response.SessionBriefResponseDTO;
import com.effortcure.enums.SessionStatus;
import com.effortcure.navigator.SceneManager;
import com.effortcure.service.interfaces.AuthServiceInterface;
import com.effortcure.service.interfaces.SessionsServiceInterface;

public class SessionsService implements SessionsServiceInterface {
    private final SessionApi sessionApi = new SessionApi();
    private AuthServiceInterface authServiceInterface = new AuthService();

    @Override
    public ApiResponse<SessionBriefResponseDTO> getSessionDetails(UUID sessionUuid) throws Exception {
        ApiResponse<SessionBriefResponseDTO> response = sessionApi.getSessionDetails(sessionUuid);
        if (response != null) {
            if (response.getStatus() == 400) {
                authServiceInterface.refreshAccessAndRefreshTokens();
                response = sessionApi.getSessionDetails(sessionUuid);
            }
            if (response.getStatus() == 401) {
                SceneManager.switchScene("/fxml/login-page.fxml", null);
                authServiceInterface.logout();
            }
        }
        return response;
    }

    @Override
    public ApiResponse<Void> DeleteSession(UUID sessionUuid) throws Exception {
        ApiResponse<Void> response = sessionApi.DeleteSession(sessionUuid);
        if (response != null) {
            if (response.getStatus() == 400) {
                authServiceInterface.refreshAccessAndRefreshTokens();
                response = sessionApi.DeleteSession(sessionUuid);
            }
            if (response.getStatus() == 401) {
                SceneManager.switchScene("/fxml/login-page.fxml", null);
                authServiceInterface.logout();
            }
        }
        return response;
    }

    @Override
    public ApiResponse<Set<LoggedNotificationResponseDTO>> getLoggedNotifications(UUID sessionUuid) throws Exception {
        ApiResponse<Set<LoggedNotificationResponseDTO>> response = sessionApi.getLoggedNotifications(sessionUuid);
        if (response != null) {
            if (response.getStatus() == 400) {
                authServiceInterface.refreshAccessAndRefreshTokens();
                response = sessionApi.getLoggedNotifications(sessionUuid);
            }
            if (response.getStatus() == 401) {
                SceneManager.switchScene("/fxml/login-page.fxml", null);
                authServiceInterface.logout();
            }
        }
        return response;
    }

    @Override
    public ApiResponse<PerformanceMetricsResponseDTO> getPerformanceMetrics(UUID sessionUuid) throws Exception {
        ApiResponse<PerformanceMetricsResponseDTO> response = sessionApi.getPerformanceMetrics(sessionUuid);
        if (response != null) {
            if (response.getStatus() == 400) {
                authServiceInterface.refreshAccessAndRefreshTokens();
                response = sessionApi.getPerformanceMetrics(sessionUuid);
            }
            if (response.getStatus() == 401) {
                SceneManager.switchScene("/fxml/login-page.fxml", null);
                authServiceInterface.logout();
            }
        }
        return response;
    }

    @Override
    public ApiResponse<Void> ModifySessionStatus(UUID sessionUuid, SessionStatus status) throws Exception {
        ApiResponse<Void> response = sessionApi.ModifySessionStatus(sessionUuid, status);
        if (response != null) {
            if (response.getStatus() == 400) {
                authServiceInterface.refreshAccessAndRefreshTokens();
                response = sessionApi.ModifySessionStatus(sessionUuid, status);
            }
            if (response.getStatus() == 401) {
                SceneManager.switchScene("/fxml/login-page.fxml", null);
                authServiceInterface.logout();
            }
        }
        return response;
    }

}
