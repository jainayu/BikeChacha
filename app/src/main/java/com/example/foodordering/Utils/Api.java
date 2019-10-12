package com.example.foodordering.Utils;

import com.example.foodordering.Model.LoginResponse;
import com.example.foodordering.Model.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {
    @FormUrlEncoded
    @POST("/register")
    Call<RegisterResponse> registerUser(
        @Field("email") String email,
        @Field("password") String password,
        @Field("full_name") String fullName
    );

    @FormUrlEncoded
    @POST("/login")
    Call<LoginResponse> loginUser(
            @Field("email") String email,
            @Field("password") String password
    );
}
