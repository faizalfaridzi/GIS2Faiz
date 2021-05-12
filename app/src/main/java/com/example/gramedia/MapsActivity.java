package com.example.gramedia;

import androidx.fragment.app.FragmentActivity;


import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.location_map);
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

        //  tambah koordinat marker
        LatLng imam = new LatLng (-0.800113, 120.164495);
        LatLng gramedia = new LatLng(-0.800783, 120.166400);

//    atur ukuran marker
        int tinggi = 100;
        int lebar = 100;

        BitmapDrawable bitmapStart = (BitmapDrawable)getResources().getDrawable(R.drawable.home);
        BitmapDrawable bitmapDes = (BitmapDrawable)getResources().getDrawable(R.drawable.jnt);

        Bitmap s = bitmapStart.getBitmap();
        Bitmap d = bitmapDes.getBitmap();

        Bitmap markerStart = Bitmap.createScaledBitmap(s, lebar, tinggi, false);
        Bitmap markerDes = Bitmap.createScaledBitmap(d, lebar, tinggi, false);

//    tambahkan marker ke map
        mMap.addMarker(new MarkerOptions().position(imam).title("Marker in Faiz")
                .snippet("My Sweet Home")
                .icon(BitmapDescriptorFactory.fromBitmap(markerStart)));

        mMap.addMarker(new MarkerOptions().position(gramedia).title("Marker in JNT Parigi")
                .snippet("JNT Cabang Parigi")
                .icon(BitmapDescriptorFactory.fromBitmap(markerDes)));

        mMap.addPolyline(new PolylineOptions().add(
                imam,
                new LatLng(-0.800043, 120.164661),
                new LatLng(-0.799663, 120.165126),
                new LatLng(-0.799850, 120.165272),
                new LatLng(-0.800896, 120.166259),
                new LatLng(-0.800834, 120.166334),
                new LatLng(-0.800783, 120.166400),
                gramedia
        ).width(10)
                .color(Color.RED));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(imam, 11.5f));
    }
}