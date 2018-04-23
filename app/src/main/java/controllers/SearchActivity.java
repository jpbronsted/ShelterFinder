package controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

import team.gatech.edu.login.R;

/**
 * Created by jpbronsted on 3/12/18.
 */

public class SearchActivity extends AppCompatActivity {

    private Button logOut;
    private Button search;

    private EditText searchShelterName;
    private EditText searchAge;
    private EditText searchGender;

    private Intent toQueryResults;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        logOut = (Button) findViewById(R.id.btnLogout);
        search = (Button) findViewById(R.id.btnSearch);

        searchShelterName = (EditText) findViewById(R.id.etSearchShelterName);
        searchAge = (EditText) findViewById(R.id.etSearchAge);
        searchGender = (EditText) findViewById(R.id.etSearchGender);

        final Intent back = new Intent(SearchActivity.this,
                WelcomeActivity.class);
        toQueryResults = new Intent(SearchActivity.this,
                QueryResultsActivity.class);

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth.signOut();
                startActivity(back);
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prepareSearchResults();
            }
        });

        auth = FirebaseAuth.getInstance();
    }

    private void prepareSearchResults() {
        Bundle extras = toQueryResults.getExtras();

        try {
            extras.getString("narrowByShelterName");
            toQueryResults.removeExtra("narrowByShelterName");
        } catch (NullPointerException e) {
            // do nothing
        }

        try {
            extras.getString("narrowByAge");
            toQueryResults.removeExtra("narrowByAge");
        } catch (NullPointerException e) {
            // do nothing
        }

        try {
            extras.getString("narrowByGender");
            toQueryResults.removeExtra("narrowByGender");
        } catch (NullPointerException e) {
            // do nothing
        }

        if (!(searchShelterName.getText().toString().equals(""))) {
            toQueryResults.putExtra("narrowByShelterName",
                    searchShelterName.getText().toString());
        }
        if (!(searchAge.getText().toString().equals(""))) {
            toQueryResults.putExtra("narrowByAge",
                    searchAge.getText().toString());
        }
        if (!(searchGender.getText().toString().equals(""))) {
            toQueryResults.putExtra("narrowByGender",
                    searchGender.getText().toString());
        }
        startActivity(toQueryResults);
    }
}
