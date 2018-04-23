package controllers;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import model.Shelter;
import team.gatech.edu.login.R;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.myMap);
        mapFragment.getMapAsync(this);
    }

    public void onMapReady(GoogleMap map) {
        for (Shelter shelter : (List<Shelter>) getIntent().getSerializableExtra("shelters")) {
            map.addMarker(new MarkerOptions().position(new LatLng(shelter.getLatitude(), shelter.getLongitude())).title(shelter.getName()));
        }
    }
}
