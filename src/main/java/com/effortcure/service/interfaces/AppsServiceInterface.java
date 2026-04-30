package com.effortcure.service.interfaces;

import java.util.List;

import com.effortcure.dto.response.AppResponseDTO;

public interface AppsServiceInterface {
    public List<AppResponseDTO> getApps() throws Exception;
}
