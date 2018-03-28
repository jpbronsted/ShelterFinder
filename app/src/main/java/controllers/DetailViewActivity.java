package controllers;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import team.gatech.edu.login.R;
import android.view.View;
import android.content.Intent;

import java.io.InputStream;
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

    TextView viewShelterName, Vacancy, updatedVacancy;
    EditText claimVacancy;
    Button backBtn, claimBtn, cancelBtn;
    List<String> list;
    String shelterName;
    String capacity;
    Shelter[] shel = Shelter.shelterData.values().toArray(new Shelter[0]);
//    int[] shelcap = new int[shel.length];
//    private void shelCap(Shelter[] shel) {
//        for(int i = 0; i <= shel.length; i++) {
//            shelcap[i] = Integer.parseInt(shel[i].getCapacity());
//        }
//    }
//



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




        // should display selected shelter's name and vacancy

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String text = extras.getString("content");
            int firstColon = text.indexOf(":");
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
                        if (Integer.parseInt(shelter.getCapacity()) - claimedVacancyNum >= 0) {
                            int newCapacity = Integer.parseInt(shelter.getCapacity()) - claimedVacancyNum;
                            shelter.setCapacity("" + newCapacity);
                            updatedVacancy.setText(shelter.getCapacity());
                        }
                    }
                }
            }
        });

    }
}
