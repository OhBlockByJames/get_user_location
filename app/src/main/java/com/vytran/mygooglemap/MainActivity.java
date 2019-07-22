package com.vytran.mygooglemap;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    String latitude = "";
    String longitude = "";
    String address = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        Intent intent = getIntent();
        latitude = intent.getStringExtra("map_latitude");
        longitude = intent.getStringExtra("map_longitude");
        address = intent.getStringExtra("map_address");

        if (latitude == null || longitude == null || address == null) {
            textView.setText("Please choose location");
        }


        textView.setText("Latitude: " + latitude + "\n" +
                "Longitude: " + longitude + "\n" +
                "Address: " + address);

    }

    public void onClick(View v) {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
        Toast.makeText(MainActivity.this, "Long click to choose location", Toast.LENGTH_LONG).show();
    }
}
