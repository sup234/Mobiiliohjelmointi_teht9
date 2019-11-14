package com.example.teht9;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends Activity {

    private Button btnRegister, btnBack;
    private EditText text_register_username, text_register_password;
    private String username;
    private String password;
    private Handler handler;
    private Context context = getApplicationContext();
    private Tietokanta t;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        if (savedInstanceState != null) {
            username = savedInstanceState.getString("text_register_username");
            password = savedInstanceState.getString("text_register_password");
        }
        btnRegister = findViewById(R.id.register_btnRegister);
        btnBack = findViewById(R.id.register_btnBack);
        text_register_username = findViewById(R.id.register_username);
        text_register_password = findViewById(R.id.register_password);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                signup();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }, 0);
            }
        });

    }

    public void signup() {
        if (!validate()) {
            onSignupFailed();
            return;
        }
    }

    public boolean validate() {
        boolean valid = true;
        username = text_register_username.toString();
        password = text_register_password.toString();

        if (username.isEmpty() || username.length() < 3) {
            Toast.makeText(context, "Username must be at least 3 characters!", Toast.LENGTH_SHORT).show();
            valid = false;
        }

        else if (password.isEmpty() || password.length() < 3) {
            Toast.makeText(context, "Password must be at least 3 characters!", Toast.LENGTH_SHORT).show();
            valid = false;
        }

        else {

        }

        return valid;
    }

    public void onSignupFailed() {
        Toast.makeText(context, "Registration failed!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("text_register_username", username);
        savedInstanceState.putString("text_register_password", password);
        super.onSaveInstanceState(savedInstanceState);

    }
}
