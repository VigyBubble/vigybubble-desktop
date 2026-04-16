package com.effortcure.service.interfaces;

import java.util.Set;
import java.util.UUID;

import com.effortcure.dto.response.ApiResponse;
import com.effortcure.dto.response.LoggedNotificationResponseDTO;
import com.effortcure.dto.response.PerformanceMetricsResponseDTO;
import com.effortcure.dto.response.SessionBriefResponseDTO;
import com.effortcure.enums.SessionStatus;

public interface SessionsServiceInterface {

    public ApiResponse<SessionBriefResponseDTO> getSessionDetails(UUID sessionUuid) throws Exception;

    public ApiResponse<Void> DeleteSession(UUID sessionUuid) throws Exception;

    public ApiResponse<Set<LoggedNotificationResponseDTO>> getLoggedNotifications(UUID sessionUuid) throws Exception;

    public ApiResponse<PerformanceMetricsResponseDTO> getPerformanceMetrics(UUID sessionUuid) throws Exception;

    public ApiResponse<Void> ModifySessionStatus(UUID sessionUuid, SessionStatus status) throws Exception;

}
