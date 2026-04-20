package com.effortcure.service.implementation;

import java.util.List;
import java.util.UUID;

import com.effortcure.api.BubbleApi;
import com.effortcure.dto.request.CreateBubbleRequestDTO;
import com.effortcure.dto.request.DirectoryRequestDTO;
import com.effortcure.dto.response.ApiResponse;
import com.effortcure.dto.response.BubbleDetailsResponseDTO;
import com.effortcure.enums.BubbleType;
import com.effortcure.service.interfaces.AuthServiceInterface;
import com.effortcure.service.interfaces.BubbleServiceInterface;
import com.effortcure.dto.request.ModifyBubbleRequestDTO;
import com.effortcure.enums.ModifyBubbleType;
import com.effortcure.navigator.SceneManager;
import com.effortcure.dto.response.AccountBubblesResponseDTO;

public class BubbleService implements BubbleServiceInterface {
    private final BubbleApi bubbleApi = new BubbleApi();
    private AuthServiceInterface authServiceInterface = new AuthService();

    @Override
    public ApiResponse<Void> createBubble(String name, String description, BubbleType type, UUID teamUuid,
            List<String> applicationsNameList, List<DirectoryRequestDTO> directoriesList) throws Exception {

        CreateBubbleRequestDTO CreateBubbleRequestDTO = new CreateBubbleRequestDTO();
        CreateBubbleRequestDTO.setName(name);
        CreateBubbleRequestDTO.setDescription(description);
        CreateBubbleRequestDTO.setType(type);
        CreateBubbleRequestDTO.setTeamUuid(teamUuid);
        CreateBubbleRequestDTO.setApplicationsNameList(applicationsNameList);
        CreateBubbleRequestDTO.setDirectoriesList(directoriesList);
        ApiResponse<Void> response = bubbleApi.createBubble(CreateBubbleRequestDTO);
        if (response != null) {
            if (response.getStatus() == 400) {
                authServiceInterface.refreshAccessAndRefreshTokens();
                response = bubbleApi.createBubble(CreateBubbleRequestDTO);
            }
            if (response.getStatus() == 401) {
                SceneManager.switchScene("/fxml/login-page.fxml", null);
                authServiceInterface.logout();
            }
        }
        return response;
    }

    @Override
    public ApiResponse<Void> modifyBubble(UUID bubbleUuid, String name, String description,
            List<String> applicationsNameList,
            List<DirectoryRequestDTO> directoriesList, ModifyBubbleType type) throws Exception {
        ModifyBubbleRequestDTO modifyBubbleNameRequestDTO = new ModifyBubbleRequestDTO();
        modifyBubbleNameRequestDTO.setName(name);
        modifyBubbleNameRequestDTO.setDescription(description);
        modifyBubbleNameRequestDTO.setApplicationsNameList(applicationsNameList);
        modifyBubbleNameRequestDTO.setDirectoriesList(directoriesList);
        ApiResponse<Void> response = bubbleApi.modifyBubble(bubbleUuid, modifyBubbleNameRequestDTO, type);
        if (response != null) {
            if (response.getStatus() == 400) {
                authServiceInterface.refreshAccessAndRefreshTokens();
                response = bubbleApi.modifyBubble(bubbleUuid, modifyBubbleNameRequestDTO, type);
            }
            if (response.getStatus() == 401) {
                SceneManager.switchScene("/fxml/login-page.fxml", null);
                authServiceInterface.logout();
            }
        }
        return response;
    }

    @Override
    public ApiResponse<Void> deleteBubble(UUID bubbleUuid) throws Exception {
        ApiResponse<Void> response = bubbleApi.deleteBubble(bubbleUuid);
        if (response != null) {
            if (response.getStatus() == 400) {
                authServiceInterface.refreshAccessAndRefreshTokens();
                response = bubbleApi.deleteBubble(bubbleUuid);
            }
            if (response.getStatus() == 401) {
                SceneManager.switchScene("/fxml/login-page.fxml", null);
                authServiceInterface.logout();
            }
        }
        return response;
    }

    @Override
    public ApiResponse<BubbleDetailsResponseDTO> getBubbleDetails(UUID bubbleUuid) throws Exception {
        ApiResponse<BubbleDetailsResponseDTO> response = bubbleApi.getBubbleDetails(bubbleUuid);
        if (response != null) {
            if (response.getStatus() == 400) {
                authServiceInterface.refreshAccessAndRefreshTokens();
                response = bubbleApi.getBubbleDetails(bubbleUuid);
            }
            if (response.getStatus() == 401) {
                SceneManager.switchScene("/fxml/login-page.fxml", null);
                authServiceInterface.logout();
            }
        }
        return response;

    }

    @Override
    public ApiResponse<List<AccountBubblesResponseDTO>> getAccountBubbles() throws Exception {
        ApiResponse<List<AccountBubblesResponseDTO>> response = bubbleApi.getAccountBubbles();
        if (response != null) {
            if (response.getStatus() == 400) {
                authServiceInterface.refreshAccessAndRefreshTokens();
                response = bubbleApi.getAccountBubbles();
            }
            if (response.getStatus() == 401) {
                SceneManager.switchScene("/fxml/login-page.fxml", null);
                authServiceInterface.logout();
            }
        }
        return response;
    }

}