package com.example.bookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.jgabrielfreitas.core.BlurImageView;

public class signUp_page extends AppCompatActivity {
    ImageButton back_arrow_sign_up_page;
    BlurImageView blur_bg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);

        blur_bg = (BlurImageView) findViewById(R.id.login_bg);
        blur_bg.setBlur(25);

        back_arrow_sign_up_page = findViewById(R.id.back_arrow_sign_up);

        back_arrow_sign_up_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(signUp_page.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
