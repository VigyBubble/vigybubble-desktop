package com.effortcure.dto.request;

import com.effortcure.enums.ModeType;

public class CreateSessionRequestDTO {
    private int estimatedDuration;
    private ModeType mode;

    public CreateSessionRequestDTO() {
    }

    public CreateSessionRequestDTO(int estimatedDuration, ModeType mode) {
        this.estimatedDuration = estimatedDuration;
        this.mode = mode;
    }

    public int getEstimatedDuration() {
        return estimatedDuration;
    }

    public void setEstimatedDuration(int estimatedDuration) {
        this.estimatedDuration = estimatedDuration;
    }

    public ModeType getMode() {
        return mode;
    }

    public void setMode(ModeType mode) {
        this.mode = mode;
    }
    



}
