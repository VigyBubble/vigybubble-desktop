package com.effortcure.dto.response;

public class LoginResponseDTO {
    private String accessToken;
    private Long accessTokenExpiresIn;
    private String expiresInUnit;
    private String tokenType;

    public LoginResponseDTO() {
    }

    public LoginResponseDTO(String accessToken, Long accessTokenExpiresIn, String expiresInUnit, String tokenType) {
        this.accessToken = accessToken;
        this.accessTokenExpiresIn = accessTokenExpiresIn;
        this.expiresInUnit = expiresInUnit;
        this.tokenType = tokenType;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Long getAccessTokenExpiresIn() {
        return accessTokenExpiresIn;
    }

    public void setAccessTokenExpiresIn(Long accessTokenExpiresIn) {
        this.accessTokenExpiresIn = accessTokenExpiresIn;
    }

    public String getExpiresInUnit() {
        return expiresInUnit;
    }

    public void setExpiresInUnit(String expiresInUnit) {
        this.expiresInUnit = expiresInUnit;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

}
