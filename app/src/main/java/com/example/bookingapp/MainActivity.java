package com.example.bookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.BlurMaskFilter;
import android.os.Bundle;

import com.jgabrielfreitas.core.BlurImageView;

public class MainActivity extends AppCompatActivity {
    BlurImageView blur_bg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        blur_bg = (BlurImageView) findViewById(R.id.login_bg);
        blur_bg.setBlur(25);

    }
}
