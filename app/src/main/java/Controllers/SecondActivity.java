package Controllers;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import Model.Shelter;
import team.gatech.edu.login.R;

public class SecondActivity extends AppCompatActivity {

    //private Button Logout;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //Logout = (Button) findViewById(R.id.btnLogout);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewShelters);

        recyclerView.setHasFixedSize(true);

        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        adapter = new RecyclerViewAdapter(Shelter.toArray());
        recyclerView.setAdapter(adapter);

        final Intent back = new Intent(SecondActivity.this, WelcomeActivity.class);

        /*Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(back);
            }
        });*/
    }
}
