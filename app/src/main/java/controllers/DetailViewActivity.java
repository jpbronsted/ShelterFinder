package controllers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import team.gatech.edu.login.R;
import android.view.View;
import android.content.Intent;

import java.util.Objects;

import model.Shelter;

/**
 * Detailed View of shelters
 */
public class DetailViewActivity extends AppCompatActivity {

    private TextView updatedVacancy;
    private EditText claimVacancy;
    private String shelterName;
    private String capacity;
    private final Shelter[] shel = Shelter.shelterData.values().toArray(new Shelter[0]);




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelter_detail_page);

        Button backBtn = findViewById(R.id.backBtn);
        Button claimBtn = findViewById(R.id.claimBtn);
        Button cancelBtn = findViewById(R.id.cancelBtn);
        TextView viewShelterName = findViewById(R.id.viewShelterName);
        TextView vacancy = findViewById(R.id.Vacancy);
        updatedVacancy = findViewById(R.id.updatedVacancy);
        claimVacancy = findViewById(R.id.claimVacancy);




        // should display selected shelter's name and vacancy

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String text = extras.getString("content");
            int firstColon = Objects.requireNonNull(text).indexOf(":");
            int secondColon = text.indexOf(":",firstColon +1);
            int thirdColon = text.indexOf(":", secondColon + 1);
            shelterName = text.substring(firstColon + 1, secondColon - 8 );
            capacity = text.substring(secondColon + 1, thirdColon - 8 );
            viewShelterName.setText(shelterName);
            updatedVacancy.setText(capacity);
        }




        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), QueryResultsActivity.class));
            }
        });


        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updatedVacancy.setText(capacity);
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
                //Collection<Shelter> shelters = new ArrayList<>();
                for (Shelter shelter : shel) {
                    String shelterName_1 = shelter.getName().toLowerCase();
                    shelterName_1 = shelterName_1.replaceAll("\\s+","");
                    shelterName = shelterName.toLowerCase();
                    shelterName = shelterName.replaceAll("\\s+","");

                    if (shelterName_1.equals(shelterName)) {
                        if ((Integer.parseInt(shelter.getCapacity()) - claimedVacancyNum) >= 0) {
                            int newCapacity = Integer.parseInt(shelter.getCapacity()) -
                                    claimedVacancyNum;
                            shelter.setCapacity("" + newCapacity);
                            updatedVacancy.setText(shelter.getCapacity());
                        }
                    }
                }
            }
        });

    }
}
