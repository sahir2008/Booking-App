package com.example.bookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.BlurMaskFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
