package com.effortcure.service.implementation;

import java.util.List;
import com.effortcure.api.BubbleApi;
import com.effortcure.dto.request.CreateBubbleRequestDTO;
import com.effortcure.dto.request.DirectoryRequestDTO;
import com.effortcure.dto.response.ApiResponse;
import com.effortcure.enums.BubbleType;
import com.effortcure.service.interfaces.BubbleServiceInterface;

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

}
