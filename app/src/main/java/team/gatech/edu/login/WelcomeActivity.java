package team.gatech.edu.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {

    private Button toLogin;
    private Button toRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        toLogin = (Button) findViewById(R.id.btnToLogin);
        toRegister = (Button) findViewById(R.id.btnToRegister);

        final Intent login = new Intent(WelcomeActivity.this, LoginActivity.class);
        final Intent register = new Intent(WelcomeActivity.this, RegisterActivity.class);

        toLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(login);
            }
        });

        toRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(register);
            }
        });
    }
}
