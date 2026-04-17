package com.effortcure.service.interfaces;

import com.effortcure.dto.request.DirectoryRequestDTO;
import com.effortcure.dto.response.AccountBubblesResponseDTO;
import com.effortcure.dto.response.ApiResponse;
import com.effortcure.dto.response.BubbleDetailsResponseDTO;
import com.effortcure.enums.BubbleType;
import com.effortcure.enums.ModifyBubbleType;

import java.util.List;
import java.util.UUID;

public interface BubbleServiceInterface {
        public ApiResponse<Void> createBubble(String name, String description, BubbleType type, UUID teamUuid,
                        List<String> applicationsNameList, List<DirectoryRequestDTO> directoriesList)
                        throws Exception;

        public ApiResponse<Void> modifyBubble(UUID bubbleUuid, String name, String description,
                        List<String> applicationsNameList,
                        List<DirectoryRequestDTO> directoriesList, ModifyBubbleType type) throws Exception;

        public ApiResponse<Void> deleteBubble(UUID bubbleUuid) throws Exception;

        public ApiResponse<BubbleDetailsResponseDTO> getBubbleDetails(UUID bubbleUuid) throws Exception;

        public ApiResponse<AccountBubblesResponseDTO> getAccountBubbles() throws Exception;

}
