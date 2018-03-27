package controllers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import team.gatech.edu.login.R;

/**
 * Created by jpbronsted on 3/7/18.
 */

public class DetailViewActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);

        TextView textView = (TextView) findViewById(R.id.detailContent);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String text = extras.getString("content");
            if (text != null) {
                textView.setText(text);
            }
        }
    }
}
