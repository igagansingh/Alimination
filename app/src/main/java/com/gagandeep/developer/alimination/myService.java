package com.gagandeep.developer.alimination;

import android.Manifest;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

/**
 * Created by Satvik on 2/2/2017.
 */

public class myService extends Service {

    private Location mDestination;

    private LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {

            float distance = mDestination.distanceTo(location);
            Log.d("MyService.java", Float.toString(distance));
            NotificationCompat.Builder mBuilder =
                    new NotificationCompat.Builder(myService.this)
                            .setSmallIcon(R.mipmap.ic_launcher)
                            .setContentTitle("Distance")
                            .setContentText(Float.toString(distance));
            NotificationManager mNotificationManager =
                    (NotificationManager) getSystemService(
                            Context.NOTIFICATION_SERVICE);
            mNotificationManager.notify(1, mBuilder.build());
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
        }

        @Override
        public void onProviderEnabled(String provider) {
        }

        @Override
        public void onProviderDisabled(String provider) {
        }
    };

    public myService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("MyService", "onStart: " + intent);

        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        mDestination = intent.getParcelableExtra("destination");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) !=
                    PackageManager.PERMISSION_GRANTED &&
                    checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) !=
                            PackageManager.PERMISSION_GRANTED) {
                return START_NOT_STICKY;
            }
        }
        locationManager.removeUpdates(locationListener);
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0,
                locationListener);


        return START_STICKY;
    }
}