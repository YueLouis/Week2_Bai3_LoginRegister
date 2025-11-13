package com.ute.loginregister;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private TextView txtBackLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txtBackLogin = findViewById(R.id.txtBackLogin);

        txtBackLogin.setOnClickListener(v -> {
            finish();   // quay lại màn Login
        });
    }
}
