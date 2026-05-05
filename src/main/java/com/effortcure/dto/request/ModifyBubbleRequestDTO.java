package com.effortcure.dto.request;

import java.util.List;

import com.effortcure.dto.response.AppResponseDTO;

public class ModifyBubbleRequestDTO {
    private String name;
    private String description;
    private List<AppResponseDTO> applications;
    private List<DirectoryRequestDTO> directoriesList;

    public ModifyBubbleRequestDTO() {
    }

    public ModifyBubbleRequestDTO(String name, String description, List<AppResponseDTO> applications,
            List<DirectoryRequestDTO> directoriesList) {
        this.name = name;
        this.description = description;
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
