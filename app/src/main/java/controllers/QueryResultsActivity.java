package controllers;

import android.content.Intent;
import android.support.annotation.VisibleForTesting;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import model.Shelter;
import team.gatech.edu.login.R;

public class QueryResultsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager manager;
    private Shelter[] data = Shelter.toArray();
    private Button Map;
    private Collection<Shelter> results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_results);


        Intent startIntent = getIntent();

        Bundle options = startIntent.getExtras();
        String shelterName;
        String age;
        String gender;

        Map = (Button) findViewById(R.id.Map);

        try {
            shelterName = options.getString("narrowByShelterName");
        } catch (NullPointerException e) {
            shelterName = "";
        }

        try {
            age = options.getString("narrowByAge");
        } catch (NullPointerException e) {
            age = "";
        }

        try {
            gender = options.getString("narrowByGender");
        } catch (NullPointerException e) {
            gender = "";
        }

        if (shelterName == null) {
            shelterName = "";
        }
        if (age == null) {
            age = "";
        }
        if (gender == null) {
            gender = "";
        }

        if (gender.toLowerCase().equals("male")) {
            gender = "men";
        }
        if (gender.toLowerCase().equals("female")) {
            gender = "women";
        }

        results = prepareSearchResults(shelterName, age, gender);

        data = new Shelter[results.size()];
        int i = 0;
        for (Shelter shelter : results) {
            data[i++] = shelter;
        }

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewShelters);
        recyclerView.setHasFixedSize(true);

        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        adapter = new RecyclerViewAdapter(data);
        recyclerView.setAdapter(adapter);

        RecyclerTouchListener listener = new RecyclerTouchListener(
                QueryResultsActivity.this, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                detailView(view, position);
            }
        });

        recyclerView.addOnItemTouchListener(listener);

        Map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QueryResultsActivity.this, MapActivity.class);
                intent.putExtra("shelters", data);
                startActivity(intent);
            }
        });
    }

    private void detailView(View view, int position) {
        Intent detailView = new Intent(QueryResultsActivity.this,
                DetailViewActivity.class);
        detailView.putExtra("content", data[position].toString());
        startActivity(detailView);
    }

    @VisibleForTesting
    public static Collection<Shelter> prepareSearchResults(String shelterName, String age, String gender) {
        if (shelterName.equals("") && age.equals("") && gender.equals("")) {
            return Shelter.shelterData.values();
        }
        Collection<Shelter> shelters = new ArrayList<>();
        for (Shelter shelter : Shelter.shelterData.values()) {
            if (shelter.getName().toLowerCase().contains(
                    shelterName.toLowerCase())
                    && shelter.getRestrictions().toLowerCase().contains(
                            age.toLowerCase())
                    && shelter.getRestrictions().toLowerCase().contains(
                            gender.toLowerCase())) {
                if (!(gender.toLowerCase().equals("men")
                        && shelter.getRestrictions().toLowerCase().contains(
                                "women"))) {
                    shelters.add(shelter);
                }
            }
        }
        return shelters;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        data = null;
    }
}
