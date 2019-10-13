package com.example.foodordering.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.foodordering.Model.RegisterResponse;
import com.example.foodordering.R;
import com.example.foodordering.Utils.RetrofitClient;
import com.example.foodordering.Utils.SharedPreferencesManager;

import retrofit2.Call;
import retrofit2.Callback;

public class RegisterActivity extends AppCompatActivity{
    private static final String KEY_EMPTY = "";
    private EditText etEmail;
    private EditText etPassword;
    private EditText etConfirmPassword;
    private EditText etFullName;
    private String email;
    private String password;
    private String confirmPassword;
    private String fullName;
    private AlertDialog.Builder builder;
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        etFullName = findViewById(R.id.etFullName);

        Button login = findViewById(R.id.btnRegisterLogin);
        Button register = findViewById(R.id.btnRegister);

        //Launch Login screen when Login Button is clicked
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Retrieve the data entered in the edit texts
                email = etEmail.getText().toString().toLowerCase().trim();
                password = etPassword.getText().toString().trim();
                confirmPassword = etConfirmPassword.getText().toString().trim();
                fullName = etFullName.getText().toString().trim();

                if (validateInputs()) {
                   //displayLoader();
                    Call<RegisterResponse> call = RetrofitClient
                            .getInstance()
                            .getApi()
                            .registerUser(email, password, fullName);

                   call.enqueue(new Callback<RegisterResponse>() {

                       @Override
                       public void onResponse(Call<RegisterResponse> call, retrofit2.Response<RegisterResponse> response) {
                           if(response.code() == 201){
                               displayMessage("Registration Successfull");
                           }
                           else if(response.code() == 422){
                               builder = new AlertDialog.Builder(RegisterActivity.this);
                               builder.setMessage("User Already Exists")
                                       .setCancelable(false)
                                       .setPositiveButton("Login", new DialogInterface.OnClickListener() {
                                           @Override
                                           public void onClick(DialogInterface dialogInterface, int i) {
                                               Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                               startActivity(intent);
                                               finish();
                                           }
                                       })
                               .setNegativeButton("Register", new DialogInterface.OnClickListener() {
                                   @Override
                                   public void onClick(DialogInterface dialogInterface, int i) {
                                       dialogInterface.cancel();
                                       Intent intent = new Intent(RegisterActivity.this, RegisterActivity.class);
                                       startActivity(intent);
                                       finish();

                                   }
                               });

                               AlertDialog alertDialog = builder.create();
                               alertDialog.show();
                           }
                       }

                       @Override
                       public void onFailure(Call<RegisterResponse> call, Throwable t) {

                       }
                   });
                }

            }
        });

    }

    /**
     * Display Progress bar while registering
     */
    private void displayMessage(String s) {
        builder = new AlertDialog.Builder(this);
        builder.setMessage(s)
        .setCancelable(false)
        .setPositiveButton("Login", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(SharedPreferencesManager.getInstance(this).isLoggedIn()){
            Intent intent = new Intent(RegisterActivity.this, HomeActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }

    /**
     * Validates inputs and shows error if any
     * @return
     */
    private boolean validateInputs() {
        if (KEY_EMPTY.equals(fullName)) {
            etFullName.setError("Full Name cannot be empty.");
            etFullName.requestFocus();
            return false;

        }
        if (KEY_EMPTY.equals(email)) {
            etEmail.setError("Email cannot be empty.");
            etEmail.requestFocus();
            return false;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            etEmail.setError("Enter a valid email");
            etEmail.requestFocus();
            return false;

        }
        if (KEY_EMPTY.equals(password)) {
            etPassword.setError("Password cannot be empty.");
            etPassword.requestFocus();
            return false;
        }
        if(password.length()<8){
            etPassword.setError("Password should be 8 character long.");
            etPassword.requestFocus();
            return false;
        }

        if (KEY_EMPTY.equals(confirmPassword)) {
            etConfirmPassword.setError("Confirm Password cannot be empty.");
            etConfirmPassword.requestFocus();
            return false;
        }
        if (!password.equals(confirmPassword)) {
            etConfirmPassword.setError("Password and Confirm Password does not match.");
            etConfirmPassword.requestFocus();
            return false;
        }

        return true;
    }
}