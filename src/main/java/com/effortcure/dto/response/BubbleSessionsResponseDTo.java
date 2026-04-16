package com.effortcure.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import com.effortcure.enums.SessionStatus;

public class BubbleSessionsResponseDTo {

    private UUID uuid;
    private String creator;
    private BigDecimal dwp;
    private SessionStatus sessionStatus;
    private LocalDateTime statusUpdatedAt;
    private LocalDateTime createdAt;

    public BubbleSessionsResponseDTo() {
    }

    public BubbleSessionsResponseDTo(UUID uuid, String creator, BigDecimal dwp, SessionStatus sessionStatus,
            LocalDateTime statusUpdatedAt, LocalDateTime createdAt) {
        this.uuid = uuid;
        this.creator = creator;
        this.dwp = dwp;
        this.sessionStatus = sessionStatus;
        this.statusUpdatedAt = statusUpdatedAt;
        this.createdAt = createdAt;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public BigDecimal getDwp() {
        return dwp;
    }

    public void setDwp(BigDecimal dwp) {
        this.dwp = dwp;
    }

    public SessionStatus getSessionStatus() {
        return sessionStatus;
    }

    public void setSessionStatus(SessionStatus sessionStatus) {
        this.sessionStatus = sessionStatus;
    }

    public LocalDateTime getStatusUpdatedAt() {
        return statusUpdatedAt;
    }

    public void setStatusUpdatedAt(LocalDateTime statusUpdatedAt) {
        this.statusUpdatedAt = statusUpdatedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}
