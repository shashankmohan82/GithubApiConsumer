package com.learntoanimate.api;

/**
 * Created by sHIVAM on 12/17/2016.
 */

public enum ApiConstants {
    CLIENT_ID(""),
    CLIENT_SECRET(""),
    USER("https://api.github.com/users/%s"),
    REPO("https://api.github.com/users/%s/repos");

    private String s;

    ApiConstants(String s) {
        this.s = s;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }
}
