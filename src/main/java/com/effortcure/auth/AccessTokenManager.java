package com.effortcure.auth;

public class AccessTokenManager {

    private static AccessTokenManager instance;

    private String accessToken;

    private AccessTokenManager() {
    }

    public static AccessTokenManager getInstance() {
        if (instance == null) {
            instance = new AccessTokenManager();
        }
        return instance;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

}
