package controllers;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import model.Shelter;
import team.gatech.edu.login.R;

public class QueryResultsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager manager;
    private Button Map;
    private Button backToSearch;
    private List<Shelter> results;

    private FirebaseAuth auth;
    private DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_results);

        Intent startIntent = getIntent();

        final Bundle options = startIntent.getExtras();

        Map = (Button) findViewById(R.id.btnMap);
        backToSearch = (Button) findViewById(R.id.btnBackToSearch);

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance().getReference();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewShelters);
        recyclerView.setHasFixedSize(true);

        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

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
                intent.putExtra("shelters", (Serializable) results);
                startActivity(intent);
            }
        });

        backToSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QueryResultsActivity.this, SearchActivity.class));
            }
        });

        Query query = database.child("shelters");

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Shelter.shelterData.clear();
                for (DataSnapshot dataPoint : dataSnapshot.getChildren()) {
                    Shelter shelter = dataPoint.getValue(Shelter.class);
                    if (shelter == null) {
                        Log.e("firebase_debugging", "retrieved null shelter data");
                    } else {
                        Shelter.shelterData.put(shelter.getName(), shelter);
                    }
                }

                String shelterName;
                String age;
                String gender;

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

                adapter = new RecyclerViewAdapter(results);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("firebase_debugging", "database read was unsuccessful");
            }
        });
    }

    private void detailView(View view, int position) {
        Intent detailView = new Intent(QueryResultsActivity.this,
                DetailViewActivity.class);
        detailView.putExtra("content", results.get(position));
        startActivity(detailView);
    }

    @VisibleForTesting
    public static List<Shelter> prepareSearchResults(String shelterName, String age, String gender) {
        List<Shelter> shelters = new ArrayList<>();

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
}
