package com.effortcure.service.interfaces;

import java.util.Set;
import java.util.UUID;

import com.effortcure.dto.request.CreateSessionRequestDTO;
import com.effortcure.dto.response.ApiResponse;
import com.effortcure.dto.response.BubbleSessionsResponseDTO;

public interface BubbleSessionServiceInterface {

    public ApiResponse<Set<BubbleSessionsResponseDTO>> getBubbleSession(UUID bubbleUuid) throws Exception;
    public ApiResponse<Void> createSession(UUID bubbleUuid, CreateSessionRequestDTO createSessionRequestDTO) throws Exception;
    
    
    
}
