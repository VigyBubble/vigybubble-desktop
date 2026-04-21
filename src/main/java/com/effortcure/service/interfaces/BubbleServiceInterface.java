package com.effortcure.service.interfaces;

import com.effortcure.dto.request.CreateBubbleRequestDTO;
import com.effortcure.dto.request.DirectoryRequestDTO;
import com.effortcure.dto.response.AccountBubblesResponseDTO;
import com.effortcure.dto.response.ApiResponse;
import com.effortcure.dto.response.BubbleDetailsResponseDTO;
import com.effortcure.enums.ModifyBubbleType;

import java.util.List;
import java.util.UUID;

public interface BubbleServiceInterface {
        public ApiResponse<Void> createBubble(CreateBubbleRequestDTO CreateBubbleRequestDTO) throws Exception;

        public ApiResponse<Void> modifyBubble(UUID bubbleUuid, String name, String description,
                        List<String> applicationsNameList,
                        List<DirectoryRequestDTO> directoriesList, ModifyBubbleType type) throws Exception;

        public ApiResponse<Void> deleteBubble(UUID bubbleUuid) throws Exception;

        public ApiResponse<BubbleDetailsResponseDTO> getBubbleDetails(UUID bubbleUuid) throws Exception;

        public ApiResponse<List<AccountBubblesResponseDTO>> getAccountBubbles() throws Exception;

}
