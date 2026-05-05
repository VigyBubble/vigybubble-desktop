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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((path == null) ? 0 : path.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DirectoryRequestDTO other = (DirectoryRequestDTO) obj;
        if (path == null) {
            if (other.path != null)
                return false;
        } else if (!path.equals(other.path))
            return false;
        if (type != other.type)
            return false;
        return true;
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
