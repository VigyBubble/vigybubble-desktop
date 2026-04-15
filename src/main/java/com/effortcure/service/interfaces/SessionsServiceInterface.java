package com.effortcure.service.interfaces;

import java.util.UUID;

import com.effortcure.dto.response.ApiResponse;
import com.effortcure.dto.response.SessionBriefResponseDTO;

public interface SessionsServiceInterface {

public ApiResponse<SessionBriefResponseDTO> getSessionDetails(UUID sessionUuid) throws Exception;
public ApiResponse<Void> DeleteSession(UUID sessionUuid) throws Exception;

    
}
