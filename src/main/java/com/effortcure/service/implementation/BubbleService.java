package com.effortcure.service.implementation;

import java.util.List;
import java.util.UUID;

import com.effortcure.api.BubbleApi;
import com.effortcure.dto.request.CreateBubbleRequestDTO;
import com.effortcure.dto.request.DirectoryRequestDTO;
import com.effortcure.dto.response.ApiResponse;
import com.effortcure.enums.BubbleType;
import com.effortcure.service.interfaces.BubbleServiceInterface;
import com.effortcure.dto.request.ModifyBubbleNameRequestDTO;

public class BubbleService implements BubbleServiceInterface {
    private final BubbleApi bubbleApi = new BubbleApi();

    @Override
    public ApiResponse<Void> createBubble(String name, String description, BubbleType type, String teamUuid,
            List<String> applicationsNameList, List<DirectoryRequestDTO> directoriesList) throws Exception {

        CreateBubbleRequestDTO CreateBubbleRequestDTO = new CreateBubbleRequestDTO();
        CreateBubbleRequestDTO.setName(name);
        CreateBubbleRequestDTO.setDescription(description);
        CreateBubbleRequestDTO.setType(type);
        CreateBubbleRequestDTO.setTeamUuid(teamUuid);
        CreateBubbleRequestDTO.setApplicationsNameList(applicationsNameList);
        CreateBubbleRequestDTO.setDirectoriesList(directoriesList);
        return bubbleApi.createBubble(CreateBubbleRequestDTO);
    }

    @Override
    public ApiResponse<Void> modifyBubbleName(UUID bubbleUuid, String name, String description,
            List<String> applicationsNameList,
            List<DirectoryRequestDTO> directoriesList) throws Exception {
        ModifyBubbleNameRequestDTO modifyBubbleNameRequestDTO = new ModifyBubbleNameRequestDTO();
        modifyBubbleNameRequestDTO.setName(name);
        modifyBubbleNameRequestDTO.setDescription(description);
        modifyBubbleNameRequestDTO.setApplicationsNameList(applicationsNameList);
        modifyBubbleNameRequestDTO.setDirectoriesList(directoriesList);
        return bubbleApi.modifyBubbleName(bubbleUuid, modifyBubbleNameRequestDTO);
    }


    @Override
    public ApiResponse<Void> modifyBubbleDirectories(UUID bubbleUuid, String name, String description,
            List<String> applicationsNameList,
            List<DirectoryRequestDTO> directoriesList) throws Exception {
        ModifyBubbleNameRequestDTO modifyBubbleDirectoriesRequestDTO = new ModifyBubbleNameRequestDTO();
        modifyBubbleDirectoriesRequestDTO.setName(name);
        modifyBubbleDirectoriesRequestDTO.setDescription(description);
        modifyBubbleDirectoriesRequestDTO.setApplicationsNameList(applicationsNameList);
        modifyBubbleDirectoriesRequestDTO.setDirectoriesList(directoriesList);
        return bubbleApi.modifyBubbleDirectories(bubbleUuid, modifyBubbleDirectoriesRequestDTO);
            }

}