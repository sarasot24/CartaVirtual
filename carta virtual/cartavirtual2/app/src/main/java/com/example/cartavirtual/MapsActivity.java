package com.example.cartavirtual;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.cartavirtual.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng Laureles = new LatLng(6.2545968, -75.6144256);
        LatLng Medellin = new LatLng(6.244197, -75.6636136);
        LatLng Poblado = new LatLng(6.2093316, -75.5702626);
        LatLng Centro = new LatLng(6.2093316, -75.5702626);
        //creacion de marcadores para cada sede
        mMap.addMarker(new MarkerOptions().position(Medellin).title("Marker in Medellin"));
        mMap.addMarker(new MarkerOptions().position(Laureles).title("Marker in laureles"));
        mMap.addMarker(new MarkerOptions().position(Poblado).title("Marker in poblado"));
        mMap.addMarker(new MarkerOptions().position(Centro).title("Marker in centro"));


        mMap.moveCamera(CameraUpdateFactory.newLatLng(Medellin));
        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        //mMap.
    }
}