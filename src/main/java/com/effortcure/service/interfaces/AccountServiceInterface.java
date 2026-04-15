package com.effortcure.service.interfaces;

import com.effortcure.dto.response.ApiResponse;
import com.effortcure.dto.response.BreifAccountInfoResponseDTO;

public interface AccountServiceInterface {
    public ApiResponse<Void> changePassword(String password, String confirmPassword) throws Exception;

    public ApiResponse<BreifAccountInfoResponseDTO> getBreifAccountInfo() throws Exception;
}
