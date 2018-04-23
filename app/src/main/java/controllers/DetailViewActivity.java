package controllers;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import team.gatech.edu.login.R;
import android.view.View;
import android.content.Intent;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.InputStream;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collection;
import model.Shelter;

/**
 * Created by jpbronsted on 3/7/18.
 */

public class DetailViewActivity extends AppCompatActivity {

    private TextView viewShelterName, Vacancy, updatedVacancy;
    private EditText claimVacancy;
    private Button backBtn, claimBtn, cancelBtn;
    private Shelter selectedShelter;

    private DatabaseReference database;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelter_detail_page);

        backBtn = (Button) findViewById(R.id.backBtn);
        claimBtn = (Button) findViewById(R.id.claimBtn);
        cancelBtn = (Button) findViewById(R.id.cancelBtn);
        viewShelterName = (TextView) findViewById(R.id.viewShelterName);
        Vacancy = (TextView) findViewById(R.id.Vacancy);
        updatedVacancy = (TextView) findViewById(R.id.updatedVacancy);
        claimVacancy = (EditText) findViewById(R.id.claimVacancy);

        database = FirebaseDatabase.getInstance().getReference();


        // should display selected shelter's name and vacancy

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            selectedShelter = (Shelter) extras.getSerializable("content");
            viewShelterName.setText(selectedShelter.getName());
            updatedVacancy.setText(selectedShelter.getCapacity());
        }

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database.child("shelters").child(selectedShelter.getName())
                        .child("capacity").setValue(selectedShelter
                        .getCapacity());
                startActivity(new Intent(getApplicationContext(), QueryResultsActivity.class));
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updatedVacancy.setText(selectedShelter.getCapacity());
            }
        });



        // should update new vacancy.
        // if selected vacancy exceeds the given vacancy then should not work
        // if selected vacancy is within the given vacancy then it should decrease and update
        // new vacancy.

        claimBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String claimedVacancy= claimVacancy.getText().toString();
                int claimedVacancyNum = Integer.parseInt(claimedVacancy);

                int newCapacity = Integer.parseInt(
                        selectedShelter.getCapacity()) - claimedVacancyNum;

                if (newCapacity >= 0) {
                    selectedShelter.setCapacity("" + newCapacity);
                    updatedVacancy.setText(selectedShelter.getCapacity());
                }


                /*
                for (Shelter shelter : shel) {
                    String shelterName_1 = shelter.getName().toLowerCase();
                    shelterName_1 = shelterName_1.replaceAll("\\s+","");
                    shelterName = shelterName.toLowerCase();
                    shelterName = shelterName.replaceAll("\\s+","");

                    if (shelterName_1.equals(shelterName)) {
                        if (Integer.parseInt(shelter.getCapacity()) - claimedVacancyNum >= 0) {
                            int newCapacity = ;
                            shelter.setCapacity("" + newCapacity);
                            updatedVacancy.setText(shelter.getCapacity());
                        }
                    }
                }
                */
            }
        });

    }
}
