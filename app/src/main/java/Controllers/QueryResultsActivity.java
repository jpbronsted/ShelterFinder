package Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import Model.Shelter;
import team.gatech.edu.login.R;

public class QueryResultsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager manager;
    private Shelter[] data = Shelter.toArray();     //TODO(1): delete the assignment to Shelter.toArray()

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

        //TODO(3): search through the shelters (stored in a HashMap called Shelter.shelterData) and put only those that match requested search terms into the array called "data"

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
    }

    private void detailView(View view, int position) {
        Intent detailView = new Intent(QueryResultsActivity.this,
                DetailViewActivity.class);
        detailView.putExtra("content", data[position].toString());
        startActivity(detailView);
    }
}
