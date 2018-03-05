package Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import Model.Shelter;
import team.gatech.edu.login.R;

public class SecondActivity extends AppCompatActivity {

    private Button Logout;
    private TextView dataOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Logout = (Button) findViewById(R.id.btnLogout);
        dataOutput = (TextView) findViewById(R.id.testOutput);

        for (Shelter shelter : Shelter.shelterData.values()) {
            dataOutput.append(shelter.toString());
        }

        final Intent back = new Intent(SecondActivity.this, WelcomeActivity.class);

        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(back);
            }
        });
    }
}
