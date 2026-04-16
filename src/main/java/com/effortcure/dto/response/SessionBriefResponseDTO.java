package com.effortcure.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

import com.effortcure.enums.ModeType;
import com.effortcure.enums.SessionStatus;

public class SessionBriefResponseDTO {

    private UUID uuid;
    private ModeType mode;
    private SessionStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime statusUpdatedAt;

    public SessionBriefResponseDTO() {
    }

    public SessionBriefResponseDTO(UUID uuid, ModeType mode, SessionStatus status, LocalDateTime createdAt,
            LocalDateTime statusUpdatedAt) {
        this.uuid = uuid;
        this.mode = mode;
        this.status = status;
        this.createdAt = createdAt;
        this.statusUpdatedAt = statusUpdatedAt;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public ModeType getMode() {
        return mode;
    }

    public void setMode(ModeType mode) {
        this.mode = mode;
    }

    public SessionStatus getStatus() {
        return status;
    }

    public void setStatus(SessionStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getStatusUpdatedAt() {
        return statusUpdatedAt;
    }

    public void setStatusUpdatedAt(LocalDateTime statusUpdatedAt) {
        this.statusUpdatedAt = statusUpdatedAt;
    }

}
