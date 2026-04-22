package com.effortcure.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

import com.effortcure.enums.BubbleType;

public class AccountBubblesResponseDTO {
    private UUID uuid;
    private String name;
    private String description;
    private BubbleType type;
    private LocalDateTime createdAt;
    private String actualDuration;
    private String estimatedDuration;

    public AccountBubblesResponseDTO() {
    }

    public AccountBubblesResponseDTO(UUID uuid, String name, String description, BubbleType type,
            LocalDateTime createdAt, String actualDuration, String estimatedDuration) {
        this.uuid = uuid;
        this.name = name;
        this.description = description;
        this.type = type;
        this.createdAt = createdAt;
        this.actualDuration = actualDuration;
        this.estimatedDuration = estimatedDuration;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getActualDuration() {
        return actualDuration;
    }

    public void setActualDuration(String actualDuration) {
        this.actualDuration = actualDuration;
    }

    public String getEstimatedDuration() {
        return estimatedDuration;
    }

    public void setEstimatedDuration(String estimatedDuration) {
        this.estimatedDuration = estimatedDuration;
    }

}
