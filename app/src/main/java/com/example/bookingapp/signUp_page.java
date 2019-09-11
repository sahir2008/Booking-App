package com.example.bookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.jgabrielfreitas.core.BlurImageView;

public class signUp_page extends AppCompatActivity {

    BlurImageView blur_bg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);

        blur_bg = (BlurImageView) findViewById(R.id.login_bg);
        blur_bg.setBlur(25);
    }
}
