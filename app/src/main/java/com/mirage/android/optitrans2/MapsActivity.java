package com.mirage.android.optitrans2;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Button btn_finish;

    String pn,pi,pm;
    Double lati,longi;
    producerDatabase myDB;

    private final static int MY_PERMISSION_FINE_LOCATION = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        myDB = new producerDatabase(this);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        btn_finish = (Button) findViewById(R.id.finish);
        btn_finish.setVisibility(View.GONE);
        Intent i=getIntent();

        pn=i.getStringExtra("prodName");
        pi=i.getStringExtra("prodID");
        pm=i.getStringExtra("prodMilk");
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


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSION_FINE_LOCATION);
            }
        }

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {

            @Override
            public void onMapClick(LatLng point) {
                mMap.clear();
                mMap.addMarker(new MarkerOptions().position(point).title("Selected Location"));
                mMap.animateCamera(CameraUpdateFactory.newLatLng(point));
                Toast.makeText(MapsActivity.this, "Latitude: " + point.latitude + "\n Longitude: " + point.longitude, Toast.LENGTH_SHORT).show();
                lati=point.latitude; longi=point.longitude;
                btn_finish.setVisibility(View.VISIBLE);

                addListenerOnButton();
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case MY_PERMISSION_FINE_LOCATION:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                        mMap.setMyLocationEnabled(true);
                    } else {
                        Toast.makeText(getApplicationContext(), "This app requires location permissions to be granted", Toast.LENGTH_LONG).show();
                        finish();
                    }
                    break;
                }
        }
    }

    public void addListenerOnButton() {

        final Context context = this;



        btn_finish.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                adddata();
                Intent intent = new Intent(context, prodTy.class);
                startActivity(intent);


            }

        });

    }

    public void adddata() {
        boolean isInserted = myDB.insertData(pn.trim(), pi.trim(), pm.trim(),lati.toString(),longi.toString());
        if(isInserted == true)
            Toast.makeText(MapsActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(MapsActivity.this,"Data not Inserted",Toast.LENGTH_LONG).show();
    }
}