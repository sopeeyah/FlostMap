package com.specialtopics.flost.Views;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private static final LatLng Fowler = new LatLng(34.126926, -118.211240);
    private static final LatLng Johnson = new LatLng(34.127530, -118.211572);
    private static final LatLng Library = new LatLng(34.126065, -118.211476);
    private static final LatLng MP = new LatLng(34.127793, -118.212401);

    private Marker mFowler;
    private Marker mJohnson;
    private Marker mLibrary;
    private Marker mMP;

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.specialtopics.flost.R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(com.specialtopics.flost.R.id.map);
        mapFragment.getMapAsync(this);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng oxy = new LatLng(34.126955, -118.211874);

        mFowler = mMap.addMarker(new MarkerOptions().position(Fowler).title("Fowler"));
        mJohnson = mMap.addMarker(new MarkerOptions().position(Johnson).title("Johnson"));
        mLibrary = mMap.addMarker(new MarkerOptions().position(Library).title("Library"));
        mMP = mMap.addMarker(new MarkerOptions().position(MP).title("Market Place"));
        float zoomLevel = 17.5f; //This goes up to 21
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(oxy, zoomLevel));
        mMap.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {

            public void onInfoWindowClick(Marker marker) {
//                Intent intent1 = new Intent(MapsActivity.this, AnotherActivity.class);
//                String title = marker.getTitle();
//                intent1.putExtra("markertitle", title);
//                startActivity(intent1);
            }
        });

    }
}
