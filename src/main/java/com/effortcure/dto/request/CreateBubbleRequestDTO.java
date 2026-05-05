package com.effortcure.dto.request;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.effortcure.dto.response.AppResponseDTO;
import com.effortcure.enums.BubbleType;

public class CreateBubbleRequestDTO {
    private String name;
    private String description;
    private BubbleType type;
    private UUID teamUuid;
    private List<AppResponseDTO> applications = new ArrayList<>();
    private List<DirectoryRequestDTO> directoriesList = new ArrayList<>();

    public CreateBubbleRequestDTO() {
    }

    public CreateBubbleRequestDTO(String name, String description, BubbleType type, UUID teamUuid,
            List<AppResponseDTO> applications, List<DirectoryRequestDTO> directoriesList) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.teamUuid = teamUuid;
        this.applications = applications;
        this.directoriesList = directoriesList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BubbleType getType() {
        return type;
    }

    public void setType(BubbleType type) {
        this.type = type;
    }

    public UUID getTeamUuid() {
        return teamUuid;
    }

    public void setTeamUuid(UUID teamUuid) {
        this.teamUuid = teamUuid;
    }

    public List<DirectoryRequestDTO> getDirectoriesList() {
        return directoriesList;
    }

    public void setDirectoriesList(List<DirectoryRequestDTO> directoriesList) {
        this.directoriesList = directoriesList;
    }

    public List<AppResponseDTO> getApplications() {
        return applications;
    }

    public void setApplications(List<AppResponseDTO> applications) {
        this.applications = applications;
    }

}
