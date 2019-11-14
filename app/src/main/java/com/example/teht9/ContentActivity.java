package com.example.teht9;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class ContentActivity extends Activity {

    private Button btnLogout;
    private ListView listview1;
    private Handler handler;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnLogout = findViewById(R.id.content_btnLogout);
        listview1 = findViewById(R.id.content_listview);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(ContentActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }, 3000);
            }
        });
    }
}
