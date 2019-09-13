package com.example.bookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class Home_Page extends AppCompatActivity {
    ImageView sakyaLogo, operaLogo;
    Button ticketsButton, logOutButton, controlPanelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__page);
        sakyaLogo = findViewById(R.id.sakya_Logo);
        operaLogo = findViewById(R.id.opera_Logo);

        ticketsButton = findViewById(R.id.tickets_Button);
        logOutButton = findViewById(R.id.logout_Button);
        controlPanelButton = findViewById(R.id.controlPanel_Button);

    }
}