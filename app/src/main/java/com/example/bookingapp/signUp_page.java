package com.example.bookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.jgabrielfreitas.core.BlurImageView;

public class signUp_page extends AppCompatActivity {
    ImageButton back_arrow_sign_up_page;
    BlurImageView blur_bg;
    EditText user_name, user_pass, user_re_pass, user_email, user_phone_number;
    Button register_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);

        blur_bg = (BlurImageView) findViewById(R.id.login_bg);
        blur_bg.setBlur(25);

        user_name = findViewById(R.id.username_signUp);
        user_pass = findViewById(R.id.password_signUp);
        user_re_pass = findViewById(R.id.re_password_signUp);
        user_email = findViewById(R.id.email_signUp);
        user_phone_number = findViewById(R.id.phoneNumber_signUp);
        register_btn = findViewById(R.id.btnRegister_signUp);

        back_arrow_sign_up_page = findViewById(R.id.back_arrow_sign_up);
        back_arrow_sign_up_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(signUp_page.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
