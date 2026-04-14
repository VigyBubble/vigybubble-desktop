package com.effortcure.dto.response;

import java.math.BigDecimal;

public class BreifAccountInfoResponseDTO {
    private String username;
    private BigDecimal dws;
    private String plan;

    public BreifAccountInfoResponseDTO() {
    }

    public BreifAccountInfoResponseDTO(String username, BigDecimal dws, String plan) {
        this.username = username;
        this.dws = dws;
        this.plan = plan;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BigDecimal getDws() {
        return dws;
    }

    public void setDws(BigDecimal dws) {
        this.dws = dws;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

}
