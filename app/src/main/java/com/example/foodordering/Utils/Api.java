package com.example.foodordering.Utils;

import com.example.foodordering.Model.DefaultResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {
    @FormUrlEncoded
    @POST("/register")
    Call<DefaultResponse> registerUser(
        @Field("email") String email,
        @Field("password") String password,
        @Field("full_name") String fullName
    );

   /* @POST("/login")
    Call<ResponseBody> loginUser(
            @Field("email") String email,
            @Field("password") String password,
    );*/
}
