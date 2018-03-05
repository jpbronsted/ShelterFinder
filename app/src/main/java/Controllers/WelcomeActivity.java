package Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import Model.Address;
import Model.PhoneNumber;
import Model.Shelter;
import team.gatech.edu.login.R;

import org.apache.commons.csv.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

public class WelcomeActivity extends AppCompatActivity {

    private Button toLogin;
    private Button toRegister;

    static boolean startup = true;

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

        if (startup) {
            startup = false;
            readData();
        }
    }

    private void readData() {
        File csvIn = new File("/home/jpbronsted/data.csv");
        if (!(csvIn.exists())) {
            return;
        }
        if (!(csvIn.canRead())) {
            return;
        }
        CSVParser parser = null;
        try {
            parser = CSVParser.parse(csvIn, StandardCharsets.UTF_8,
                    CSVFormat.DEFAULT);
            Iterator<CSVRecord> iterator = parser.getRecords().iterator();
            while (iterator.hasNext()) {
                CSVRecord next = iterator.next();
                String name = next.get("Shelter Name");
                Integer capacity = Integer.valueOf(next.get("Capacity"));
                String restrictions = next.get("Restrictions");
                Double latitude = Double.valueOf(next.get("Latitude"));
                Double longitude = Double.valueOf(next.get("Longitude"));
                Address address = new Address(next.get("Address"));
                PhoneNumber phoneNumber = new PhoneNumber(
                        next.get("Phone Number"));
                Shelter.shelterData.put(name, new Shelter(name, phoneNumber,
                        address, capacity, latitude, longitude, restrictions));
            }
        } catch (IOException e) {
            System.out.print("IO ERROR during data read");
        }
    }
}
