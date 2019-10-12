package com.example.foodordering.Utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.foodordering.Model.User;

public class SharedPreferencesManager {
    private static SharedPreferencesManager instance;
    private Context context;
    private static final String SHARED_PREF_NAME = "my_shared_pref";

    private SharedPreferencesManager(Context context){
        this.context = context;
    }

    public static synchronized SharedPreferencesManager getInstance(Context context){
        if(instance == null){
            instance = new SharedPreferencesManager(context);
        }

        return instance;
    }

    public void saveUser(User user){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt("user_id", user.getUserId());
        editor.putString("full_name", user.getFullName());
        editor.putString("emai_id", user.getEmailId());

        editor.apply();
    }

    public  boolean isLoggedIn(){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt("user_id", -1)!= -1;
    }

    public User getUser(){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        User user = new User(sharedPreferences.getString("full_name",null),
                sharedPreferences.getString("email_id", null),
                sharedPreferences.getInt("user_id", -1));
        return  user;
    }
    public void clearUser(){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

}
