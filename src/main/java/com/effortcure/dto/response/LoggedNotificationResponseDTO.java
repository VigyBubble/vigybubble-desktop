package com.effortcure.dto.response;

import java.time.LocalDateTime;

public class LoggedNotificationResponseDTO {
    private String title;
    private String description;
    private LocalDateTime loggedAt;

    public LoggedNotificationResponseDTO() {
    }

    public LoggedNotificationResponseDTO(String title, String description, LocalDateTime loggedAt) {
        this.title = title;
        this.description = description;
        this.loggedAt = loggedAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getLoggedAt() {
        return loggedAt;
    }

    public void setLoggedAt(LocalDateTime loggedAt) {
        this.loggedAt = loggedAt;
    }

}
