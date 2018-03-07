package Controllers;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import Model.Shelter;
import team.gatech.edu.login.R;

public class SecondActivity extends AppCompatActivity {

    //private Button Logout;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager manager;
    private Shelter[] data = Shelter.toArray();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //Logout = (Button) findViewById(R.id.btnLogout);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewShelters);

        recyclerView.setHasFixedSize(true);

        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        adapter = new RecyclerViewAdapter(data);
        recyclerView.setAdapter(adapter);

        RecyclerTouchListener listener = new RecyclerTouchListener(
                SecondActivity.this, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                detailView(view, position);
            }
        });

        recyclerView.addOnItemTouchListener(listener);

        final Intent back = new Intent(SecondActivity.this, WelcomeActivity.class);


        /*Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(back);
            }
        });*/
    }

    private void detailView(View view, int position) {
        Intent detailView = new Intent(SecondActivity.this,
                DetailViewActivity.class);
        detailView.putExtra("content", data[position].toString());
        startActivity(detailView);
    }
}
