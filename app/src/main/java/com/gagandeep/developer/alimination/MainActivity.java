package com.gagandeep.developer.alimination;

import android.content.Intent;
import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    Location destination;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent i = new Intent(this, MyService.class);
        destination = new Location("");
        destination.setLatitude(28.6792d);
        destination.setLongitude(77.0888d);
        i.putExtra("destination" ,destination);
        this.startService(i);
//        startActivity(new Intent(this,EnterDetails.class));
    }
}
