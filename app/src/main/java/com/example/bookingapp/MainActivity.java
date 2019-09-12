package com.example.bookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.BlurMaskFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.jgabrielfreitas.core.BlurImageView;

public class MainActivity extends AppCompatActivity {
    Button sign_up_btn, login_btn;
    EditText email_edit_txt_login, pass_edit_txt_login;

    DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    FirebaseAuth auth = FirebaseAuth.getInstance();
    StorageReference storageReference = FirebaseStorage.getInstance().getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BlurImageView blur_bg = (BlurImageView) findViewById(R.id.login_bg);
        blur_bg.setBlur(25);

        sign_up_btn = findViewById(R.id.sign_up);
        login_btn = findViewById(R.id.login_btn);
        email_edit_txt_login = findViewById(R.id.email_login_edit_txt);
        pass_edit_txt_login = findViewById(R.id.pass_login_edit_txt);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(MainActivity.this, Home_Page.class);
                startActivity(intent);
            }
        });

        sign_up_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(MainActivity.this, signUp_page.class);
                startActivity(intent);
            }
        });

    }
}
