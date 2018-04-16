package controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Objects;

import team.gatech.edu.login.R;


public class SearchActivity extends AppCompatActivity {

    private EditText searchShelterName;
    private EditText searchAge;
    private EditText searchGender;

    private Intent toQueryResults;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Button logOut = findViewById(R.id.btnLogout);
        Button search = findViewById(R.id.btnSearch);

        searchShelterName = findViewById(R.id.etSearchShelterName);
        searchAge = findViewById(R.id.etSearchAge);
        searchGender = findViewById(R.id.etSearchGender);

        final Intent back = new Intent(SearchActivity.this,
                WelcomeActivity.class);
        toQueryResults = new Intent(SearchActivity.this,
                QueryResultsActivity.class);

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(back);
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prepareSearchResults();
            }
        });
    }

    private void prepareSearchResults() {
        Bundle extras = toQueryResults.getExtras();

        try {
            Objects.requireNonNull(extras).getString("narrowByShelterName");
            toQueryResults.removeExtra("narrowByShelterName");
        } catch (NullPointerException e) {
            // do nothing
        }

        try {
            Objects.requireNonNull(extras).getString("narrowByAge");
            toQueryResults.removeExtra("narrowByAge");
        } catch (NullPointerException e) {
            // do nothing
        }

        try {
            Objects.requireNonNull(extras).getString("narrowByGender");
            toQueryResults.removeExtra("narrowByGender");
        } catch (NullPointerException e) {
            // do nothing
        }

        if (!("".equals(searchShelterName.getText().toString()))) {
            toQueryResults.putExtra("narrowByShelterName",
                    searchShelterName.getText().toString());
        }
        if (!("".equals(searchAge.getText().toString()))) {
            toQueryResults.putExtra("narrowByAge",
                    searchAge.getText().toString());
        }
        if (!("".equals(searchGender.getText().toString()))) {
            toQueryResults.putExtra("narrowByGender",
                    searchGender.getText().toString());
        }
        startActivity(toQueryResults);
    }
}
