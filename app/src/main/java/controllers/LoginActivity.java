package controllers;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Parcel;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import team.gatech.edu.login.R;
import model.User;

public class LoginActivity extends AppCompatActivity {

    private EditText ID;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter = 5;

    ImageView imageView;
    AnimationDrawable anim;

    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener authListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ID = (EditText) findViewById(R.id.etID);
        Password = (EditText) findViewById(R.id.etPassword);
        Info = (TextView) findViewById(R.id.tvInfo);
        Login = (Button) findViewById(R.id.btnLogin);
        imageView = (ImageView)findViewById(R.id.imageView10);
        if (imageView == null) throw new AssertionError();
        imageView.setBackgroundResource(R.drawable.animation_loading);
        anim = (AnimationDrawable)imageView.getBackground() ;
        anim.start();

        Info.setText("# of attempts remaining: 5");

        auth = FirebaseAuth.getInstance();

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(ID.getText().toString(), Password.getText().toString());
            }
        });

        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser currentUser = firebaseAuth.getCurrentUser();
                if (currentUser != null) {
                    startActivity(new Intent(LoginActivity.this,
                            SearchActivity.class));
                }
            }
        };
    }

    private void validate(final String userID, String userPassword) {
        auth.signInWithEmailAndPassword(userID, userPassword)
                .addOnCompleteListener(this,
                        new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Log.w("firebase_debugging", "user login successful: " + userID);
                    startActivity(new Intent(LoginActivity.this,
                            SearchActivity.class));
                } else {
                    Log.w("firebase debugging", "user login failed: " + userID);
                    counter--;

                    Info.setText("# of attempts remaining: "
                            + String.valueOf(counter));

                    if (counter == 0) {
                        Login.setEnabled(false);
                    }
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        auth.addAuthStateListener(authListener);
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (authListener != null) {
            auth.removeAuthStateListener(authListener);
        }
    }
}
