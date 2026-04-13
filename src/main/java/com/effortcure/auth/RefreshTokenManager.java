package com.effortcure.auth;

import java.util.prefs.Preferences;

public class RefreshTokenManager {
    private static final Preferences prefs = Preferences.userNodeForPackage(AccessTokenManager.class);

    public static void saveRefreshToken(String token) {
        if (token != null)
            prefs.put("refreshToken", token);
    }

    public static String getRefreshToken() {
        return prefs.get("refreshToken", null);
    }

    public static void deleteRefreshToken() {
        prefs.remove("refreshToken");
    }
}
