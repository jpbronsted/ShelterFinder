package controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import team.gatech.edu.login.R;
import model.User;

/**
 * Login Activity
 */
public class LoginActivity extends AppCompatActivity {

    private EditText ID;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ID = findViewById(R.id.etID);
        Password = findViewById(R.id.etPassword);
        Info = findViewById(R.id.tvInfo);
        Login = findViewById(R.id.btnLogin);

        Info.setText("# of attempts remaining: 5");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(ID.getText().toString(), Password.getText().toString());
            }
        });
    }

    private void validate(String userID, String userPassword) {
        User requestedUser = User.userRegistry.get(userID);
        if ((requestedUser != null) &&
                requestedUser.getPassword().equals(userPassword)) {
            Intent intent = new Intent(LoginActivity.this, SearchActivity.class);
            startActivity(intent);
        } else {
            counter--;

            Info.setText("# of attempts remaining: " + String.valueOf(counter));

            if (counter == 0) {
                Login.setEnabled(false);
            }
        }
    }
}
