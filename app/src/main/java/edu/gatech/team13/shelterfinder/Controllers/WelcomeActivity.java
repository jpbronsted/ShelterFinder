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

    public void onLoginPressed(android.view.View view) {
        //TODO: handle what happens when the user presses the "login" button in the welcome screen
    }

    public void onSignupPressed(android.view.View view) {
        //TODO: handle what happens when the user presses the "signup" button in the welcome screen
    }
}
