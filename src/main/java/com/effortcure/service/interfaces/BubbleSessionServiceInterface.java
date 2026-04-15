package com.effortcure.service.interfaces;

import java.util.UUID;

import com.effortcure.dto.response.ApiResponse;
import com.effortcure.dto.response.BubbleSessionsResponseDTo;

public interface BubbleSessionServiceInterface {

    public ApiResponse<BubbleSessionsResponseDTo> getBubbleSession(UUID bubbleUuid) throws Exception;
    
}
