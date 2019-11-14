package com.example.teht9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button btnLogin, btnRegister;
    private EditText text_login_username, text_login_password;
    private String username;
    private String password;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            username = savedInstanceState.getString("text_login_username");
            password = savedInstanceState.getString("text_login_password");
        }

        btnLogin = findViewById(R.id.login_btnLogin);
        btnRegister = findViewById(R.id.login_btnRegister);
        text_login_username = findViewById(R.id.login_username);
        text_login_password = findViewById(R.id.login_password);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }, 0);
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("text_login_username", username);
        savedInstanceState.putString("text_login_password", password);
        super.onSaveInstanceState(savedInstanceState);

    }
}
