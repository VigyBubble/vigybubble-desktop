package com.effortcure.dto.request;

import java.util.List;

public class ModifyBubbleRequestDTO {
      private String name;
    private String description;
    private List<String> applicationsNameList;
    private List<DirectoryRequestDTO> directoriesList;

    public ModifyBubbleRequestDTO() {
    }

    public ModifyBubbleRequestDTO(String name, String description, List<String> applicationsNameList,
            List<DirectoryRequestDTO> directoriesList) {
        this.name = name;
        this.description = description;
        this.applicationsNameList = applicationsNameList;
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

    public List<String> getApplicationsNameList() {
        return applicationsNameList;
    }

    public void setApplicationsNameList(List<String> applicationsNameList) {
        this.applicationsNameList = applicationsNameList;
    }

    public List<DirectoryRequestDTO> getDirectoriesList() {
        return directoriesList;
    }

    public void setDirectoriesList(List<DirectoryRequestDTO> directoriesList) {
        this.directoriesList = directoriesList;
    }

}
