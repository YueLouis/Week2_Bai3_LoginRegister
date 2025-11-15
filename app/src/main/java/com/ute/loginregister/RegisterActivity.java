package com.ute.loginregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText edtFullName, edtRegEmail, edtRegPassword, edtRegConfirm;
    private ImageButton btnRegister;   // 🔹 Đổi thành ImageButton
    private TextView txtBackLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtFullName     = findViewById(R.id.edtFullName);
        edtRegEmail     = findViewById(R.id.edtRegEmail);
        edtRegPassword  = findViewById(R.id.edtRegPassword);
        edtRegConfirm   = findViewById(R.id.edtRegConfirm);
        btnRegister     = findViewById(R.id.btnRegister);   // ImageButton
        txtBackLogin    = findViewById(R.id.txtBackLogin);

        // Dòng "Already have an account? Login" → quay về Login
        txtBackLogin.setOnClickListener(v -> finish());

        // Nút mũi tên xanh / cam ở Register → kiểm tra + vào Home
        btnRegister.setOnClickListener(v -> {
            String name    = edtFullName.getText().toString().trim();
            String email   = edtRegEmail.getText().toString().trim();
            String pass    = edtRegPassword.getText().toString().trim();
            String confirm = edtRegConfirm.getText().toString().trim();

            if (name.isEmpty() || email.isEmpty() || pass.isEmpty() || confirm.isEmpty()) {
                Toast.makeText(this,
                        "Vui lòng điền đầy đủ thông tin",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            if (!pass.equals(confirm)) {
                Toast.makeText(this,
                        "Mật khẩu xác nhận không khớp",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            // Sau khi đăng ký thành công (demo)
            Toast.makeText(this,
                    "Register success (demo)",
                    Toast.LENGTH_SHORT).show();

            // Quay lại màn Login
            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();   // đóng Register

        });
    }
}
