package edu.gatech.team13.shelterfinder.Controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import edu.gatech.team13.shelterfinder.R;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onLoginSelectPressed(android.view.View view) {
        // TODO: take the user to the login screen
    }

    public void onSignupPressed(android.view.View view) {
        // this button currently does not have any functionality
    }
}
