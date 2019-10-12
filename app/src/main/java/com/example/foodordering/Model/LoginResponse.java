package com.example.foodordering.Model;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    private boolean error;
    private String message;

    @SerializedName("member")
    private User user;

    public LoginResponse(boolean error, String message, User user) {
        this.error = error;
        this.message = message;
        this.user = user;
    }

    public boolean isError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public User getUser() {
        return user;
    }
}
