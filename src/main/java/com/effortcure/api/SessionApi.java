package com.effortcure.api;

import java.net.http.HttpResponse;
import java.util.Set;
import java.util.UUID;

import com.effortcure.auth.AccessTokenManager;
import com.effortcure.dto.response.ApiResponse;
import com.effortcure.dto.response.LoggedNotificationResponseDTO;
import com.effortcure.dto.response.PerformanceMetricsResponseDTO;
import com.effortcure.dto.response.SessionBriefResponseDTO;
import com.effortcure.enums.SessionStatus;
import com.effortcure.util.ApiClientUtil;
import com.effortcure.util.JsonUtil;
import com.fasterxml.jackson.core.type.TypeReference;

public class SessionApi {

    private final String BASE_URL = "http://localhost:9090/api/v1/sessions/";

    public ApiResponse<SessionBriefResponseDTO> getSessionDetails(UUID sessionUuid) throws Exception {

        HttpResponse<String> response = ApiClientUtil.get(BASE_URL + sessionUuid, null,
                AccessTokenManager.getInstance().getAccessToken(),
                null);
        if (response.statusCode() == 403)
            return null;
        return JsonUtil.fromJson(response.body(), new TypeReference<ApiResponse<SessionBriefResponseDTO>>() {
        });

    }

    public ApiResponse<Void> DeleteSession(UUID sessionUuid) throws Exception {

        HttpResponse<String> response = ApiClientUtil.delete(BASE_URL + sessionUuid, null,
                AccessTokenManager.getInstance().getAccessToken(),
                null);
        if (response.statusCode() == 403)
            return null;
        return JsonUtil.fromJson(response.body(), new TypeReference<ApiResponse<Void>>() {
        });

    }

    public ApiResponse<Set<LoggedNotificationResponseDTO>> getLoggedNotifications(UUID sessionUuid) throws Exception {
        HttpResponse<String> response = ApiClientUtil.get(BASE_URL + sessionUuid + "/logged-notifictions", null,
                AccessTokenManager.getInstance().getAccessToken(),
                null);
        if (response.statusCode() == 403)
            return null;
        return JsonUtil.fromJson(response.body(), new TypeReference<ApiResponse<Set<LoggedNotificationResponseDTO>>>() {
        });
    }

    public ApiResponse<PerformanceMetricsResponseDTO> getPerformanceMetrics(UUID sessionUuid) throws Exception {
        HttpResponse<String> response = ApiClientUtil.get(BASE_URL + sessionUuid + "/performance-metrics", null,
                AccessTokenManager.getInstance().getAccessToken(),
                null);
        if (response.statusCode() == 403)
            return null;
        return JsonUtil.fromJson(response.body(), new TypeReference<ApiResponse<PerformanceMetricsResponseDTO>>() {
        });
    }

    public ApiResponse<Void> ModifySessionStatus(UUID sessionUuid, SessionStatus status) throws Exception {
        HttpResponse<String> response = ApiClientUtil.patch(BASE_URL + sessionUuid,
                 JsonUtil.toJson(status),
                AccessTokenManager.getInstance().getAccessToken(),
                null);
        if (response.statusCode() == 403)
            return null;
        return JsonUtil.fromJson(response.body(), new TypeReference<ApiResponse<Void>>() {
        });
    }

}
