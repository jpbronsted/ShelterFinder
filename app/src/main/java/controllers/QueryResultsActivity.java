package controllers;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

import model.Shelter;
import team.gatech.edu.login.R;

/**
 * search shelters
 */
public class QueryResultsActivity extends AppCompatActivity {

    @Nullable
    private Shelter[] data = Shelter.toArray();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_results);


        Intent startIntent = getIntent();

        Bundle options = startIntent.getExtras();
        String shelterName;
        String age;
        String gender;

        try {
            shelterName = Objects.requireNonNull(options).getString("narrowByShelterName");
        } catch (NullPointerException e) {
            shelterName = "";
        }

        try {
            age = Objects.requireNonNull(options).getString("narrowByAge");
        } catch (NullPointerException e) {
            age = "";
        }

        try {
            gender = Objects.requireNonNull(options).getString("narrowByGender");
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

        if ("male".equals(gender.toLowerCase())) {
            gender = "men";
        }
        if ("female".equals(gender.toLowerCase())) {
            gender = "women";
        }

        Collection<Shelter> results = prepareSearchResults(shelterName, age, gender);

        data = new Shelter[results.size()];
        int i = 0;
        for (Shelter shelter : results) {
            data[i] = shelter;
            i++;
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerViewShelters);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        RecyclerView.Adapter adapter = new RecyclerViewAdapter(data);
        recyclerView.setAdapter(adapter);

        RecyclerView.OnItemTouchListener listener = new RecyclerTouchListener(
                QueryResultsActivity.this, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                detailView(position);
            }
        });

        recyclerView.addOnItemTouchListener(listener);
    }

    private void detailView(int position) {
        Intent detailView = new Intent(QueryResultsActivity.this,
                DetailViewActivity.class);
        detailView.putExtra("content", data[position].toString());
        startActivity(detailView);
    }

    /**
     * prepare for search results
     * @param shelterName shelter name
     * @param age age
     * @param gender gender
     * @return shelters
     */
    @VisibleForTesting
    public static Collection<Shelter> prepareSearchResults(String shelterName, String age,
                                                           String gender) {
        Collection<model.Shelter> shelterValues = Shelter.shelterData.values();

        if ("".equals(shelterName) && "".equals(age) && "".equals(gender)) {
            return shelterValues;
        }
        Collection<Shelter> shelters = new ArrayList<>();
        for (Shelter shelter : shelterValues) {
            if (shelter.getName().toLowerCase().contains(
                    shelterName.toLowerCase())
                    && shelter.getRestrictions().toLowerCase().contains(
                            age.toLowerCase())
                    && shelter.getRestrictions().toLowerCase().contains(
                            gender.toLowerCase())) {
                if (!("men".equals(gender.toLowerCase())
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
