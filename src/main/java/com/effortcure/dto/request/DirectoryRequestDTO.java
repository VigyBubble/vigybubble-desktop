package com.effortcure.dto.request;

import com.effortcure.enums.DirectoryType;

public class DirectoryRequestDTO {
    private String path;
 private DirectoryType type;

    public DirectoryRequestDTO() {
    }

    public DirectoryRequestDTO(String path, DirectoryType type) {
        this.path = path;
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public DirectoryType getType() {
        return type;
    }

    public void setType(DirectoryType type) {
        this.type = type;
    }
}
