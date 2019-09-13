package com.example.bookingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.BlurMaskFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.jgabrielfreitas.core.BlurImageView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    Button sign_up_btn, login_btn;
    EditText email_edit_txt_login, pass_edit_txt_login;

//    DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    FirebaseAuth auth = FirebaseAuth.getInstance();
    StorageReference storageReference = FirebaseStorage.getInstance().getReference();
    CallbackManager callbackManager;
    private static final String EMAIL = "email";
    LoginButton loginButton;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BlurImageView blur_bg = (BlurImageView) findViewById(R.id.login_bg);
        blur_bg.setBlur(25);
        loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions(Arrays.asList(EMAIL));
        callbackManager = CallbackManager.Factory.create();
        mAuth = FirebaseAuth.getInstance();

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
                AccessToken accessToken = loginResult.getAccessToken();
                handleFacebookAccessToken(accessToken);
            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });

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

    String TAG = "FACEBOOK";

    private void handleFacebookAccessToken(AccessToken token) {
        Log.d(TAG, "handleFacebookAccessToken:" + token);

        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        // ...
                    }
                });
    }

    private void updateUI(FirebaseUser user) {
        if(user != null){
            // intent to homepage
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
}
