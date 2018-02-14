package edu.gatech.team13.shelterfinder.Controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import edu.gatech.team13.shelterfinder.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onLogoutPressed(android.view.View view) {
        //TODO: take the user back to the welcome screen (activity_welcome)
    }
}
