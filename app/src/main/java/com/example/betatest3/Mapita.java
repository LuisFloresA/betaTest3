package com.example.betatest3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Mapita extends FragmentActivity implements OnMapReadyCallback {
    GoogleMap mapAPI;
    SupportMapFragment mapFragment;
    TextView datos;
    String valorR;
    Bundle variableR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapita);
        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapAPI);
        mapFragment.getMapAsync(this);
        datos = (TextView)findViewById(R.id.txtA);
        variableR = getIntent().getExtras();
        valorR = variableR.getString("key1");
        datos.setText(valorR);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapAPI = googleMap;
        LatLng UST = new LatLng(-29.908579, -71.257743);
        LatLng AGU = new LatLng(-29.905618, -71.255288);
        mapAPI.addMarker(new MarkerOptions().position(UST).title("ES LA U LOCO"));
        mapAPI.addMarker(new MarkerOptions().position(AGU).title("AAAA"));
        mapAPI.moveCamera(CameraUpdateFactory.newLatLngZoom(UST,16));
    }
}