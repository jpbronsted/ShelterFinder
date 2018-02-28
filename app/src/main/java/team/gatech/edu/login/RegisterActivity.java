package team.gatech.edu.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * Created by jpbronsted on 2/26/18.
 */

public class RegisterActivity extends AppCompatActivity {

    private EditText id;
    private EditText password;
    private Spinner type;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        id = (EditText) findViewById(R.id.etID);
        password = (EditText) findViewById(R.id.etPassword);
        type = (Spinner) findViewById(R.id.sprType);
        register = (Button) findViewById(R.id.btnRegister);

        ArrayAdapter<String> typeAdapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, AccountType.values());
        typeAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        type.setAdapter(typeAdapter);

        final Intent welcome = new Intent(RegisterActivity.this, WelcomeActivity.class);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeNewUser(id.getText().toString(),
                        password.getText().toString(),
                        type.getSelectedItem().toString());
                startActivity(welcome);
            }
        });
    }

    private void makeNewUser(String userID, String userPassword,
                             String userType) {
        AccountType type = null;
        switch (userType) {
            case "USER":
                type = AccountType.USER;
                break;
            case "ADMIN":
                type = AccountType.ADMIN;
                break;
        }
        User.userRegistry.put(userID, new User(userID, userPassword, type));
    }
}
