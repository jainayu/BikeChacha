package com.example.foodordering.Model;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("full_name")
    private String fullName;
    @SerializedName("email_id")
    private String emailId;
    @SerializedName("user_id")
    int userId;

    public User(String fullName, String emailId, int userId) {
        this.fullName = fullName;
        this.emailId = emailId;
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmailId() {
        return emailId;
    }

    public int getUserId() {
        return userId;
    }
}
