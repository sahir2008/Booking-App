package com.example.bookingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.jgabrielfreitas.core.BlurImageView;

public class signUp_page extends AppCompatActivity {
    ImageButton back_arrow_sign_up_page;
    BlurImageView blur_bg;
    EditText user_pass, user_re_pass, user_email;
    Button register_btn;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);

        blur_bg = (BlurImageView) findViewById(R.id.login_bg);
        blur_bg.setBlur(25);

        mAuth = FirebaseAuth.getInstance();


        user_pass = findViewById(R.id.password_signUp);
        user_re_pass = findViewById(R.id.re_password_signUp);
        user_email = findViewById(R.id.email_signUp);
        register_btn = findViewById(R.id.btnRegister_signUp);

        back_arrow_sign_up_page = findViewById(R.id.back_arrow_sign_up);


        back_arrow_sign_up_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(signUp_page.this, MainActivity.class);
                startActivity(intent);
            }
        });


        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (user_email.getText().toString().isEmpty()) {
                    Toast.makeText(signUp_page.this, "E-mail is empty fill pls", Toast.LENGTH_SHORT).show();
                }
                else if (user_pass.getText().toString().isEmpty() || user_re_pass.getText().toString().isEmpty()) {
                    Toast.makeText(signUp_page.this, "password is empty pls fill", Toast.LENGTH_SHORT).show();
                }
                else if (!user_pass.getText().toString().equals(user_re_pass.getText().toString())) {
                    Toast.makeText(signUp_page.this, "Passwords does not match", Toast.LENGTH_SHORT).show();
                }
                else if (user_pass.getText().toString().length() != 8){
                    Toast.makeText(signUp_page.this, "Password can't be less than 8 characters", Toast.LENGTH_SHORT).show();
                }
                else {
                    register(user_email.getText().toString(), user_pass.getText().toString());
                }
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    void updateUI(FirebaseUser currentUser) {
        if (currentUser != null) {
            // navigate to home
            Intent intent = new Intent(signUp_page.this, Home_Page.class);
            startActivity(intent);
        }
    }

    public String TAG = "SIGNUP";

    public void register(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
//                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(signUp_page.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
    }

}
