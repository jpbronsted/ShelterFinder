package controllers;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.content.Context;
import android.widget.RelativeLayout;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import model.Shelter;
import team.gatech.edu.login.R;
import org.apache.commons.csv.*;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

public class WelcomeActivity extends AppCompatActivity {

    private Button toLogin;
    private Button toRegister;
    RelativeLayout tophalf,bothalf;
    Animation uptodown, downtoup;

    //private DatabaseReference database;

    //static boolean startup = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        toLogin = (Button) findViewById(R.id.btnToLogin);
        toRegister = (Button) findViewById(R.id.btnToRegister);
        tophalf = (RelativeLayout) findViewById(R.id.tophalf);
        bothalf = (RelativeLayout) findViewById(R.id.bothalf);
        uptodown = AnimationUtils.loadAnimation(this,R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this,R.anim.downtoup);
        tophalf.setAnimation(uptodown);
        bothalf.setAnimation(downtoup);

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

        //database = FirebaseDatabase.getInstance().getReference();

        /*
        if (startup) {
            startup = false;
            try {
                readData(getBaseContext());
            } catch (IOException e) {
                finish();
            }
        }
        */
    }

    /*
    private void readData(Context context) throws IOException {
        AssetManager assMan = context.getAssets();
        InputStream inStream = assMan.open("data.csv");
        CSVParser parser = CSVParser.parse(inStream, StandardCharsets.UTF_8,
                CSVFormat.DEFAULT.withFirstRecordAsHeader());
        Iterator<CSVRecord> iterator = parser.getRecords().iterator();
        while (iterator.hasNext()) {
            CSVRecord next = iterator.next();
            String name = next.get("Shelter Name");
            String capacity = next.get("Capacity");
            String restrictions = next.get("Restrictions");
            Double latitude = Double.valueOf(next.get("Latitude "));
            Double longitude = Double.valueOf(next.get("Longitude "));
            String address = next.get("Address");
            String phoneNumber = next.get("Phone Number");
            Shelter shelter = new Shelter(name, phoneNumber,
                    address, capacity, latitude, longitude, restrictions);
            database.child("shelters").setValue(shelter);
        }
        parser.close();
        inStream.close();
    }
    */
}
