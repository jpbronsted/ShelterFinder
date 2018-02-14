package edu.gatech.team13.shelterfinder.Controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import edu.gatech.team13.shelterfinder.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onLoginPressed(android.view.View view) {
        /*
        TODO: take in the values stored in the username and password fields and compare them
        against hardcoded username ("user") and password ("pass"); if the login is successful,
        take the user to the main application screen (activity_main); if the login is unsuccessful,
        make the text indicating an error visible (see "textview_failed_login_attempt" in
        activity_login.xml)
         */
    }

    public void onCancelPressed(android.view.View view) {
        // TODO: take the user back to the welcome screen (activity_welcome)
    }
}
