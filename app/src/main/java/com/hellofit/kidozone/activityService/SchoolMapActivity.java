package com.hellofit.kidozone.activityService;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.hellofit.kidozone.R;

import java.io.IOException;
import java.util.List;

/***
 * The Activity to display the user location and calculate the distance between user and school in the suburb
 */
public class SchoolMapActivity extends AppCompatActivity {

    private static final String TAG = "GpsActivity";
    private LocationManager locationManager;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.school_map_activity);

        editText = (EditText) findViewById(R.id.editText) ;
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (!(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER))) {
            Toast.makeText(this, "Please enable network or GPS service!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivityForResult(intent, 0);
        }

        try {
            Location location;
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if(location == null) {
                Log.d(TAG, "onCreate.location = null");
                location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            }
            Log.d(TAG, "onCreate.location = " + location);

            updateView(location);

            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3000, 5, locationListener);
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 3000, 5, locationListener);

        } catch (SecurityException e) {
            e.printStackTrace();
        }
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        try {
            locationManager.removeUpdates(locationListener);
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        super.onDestroy();
    }

    private LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            Log.d(TAG, "onProviderDisabled.location = " + location);
            updateView(location);
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            Log.d(TAG, "onStatusChanged() called with " + "provider = [" + provider + "], status = [" + status + "], extras = [" + extras + "]");
            switch (status) {
                case LocationProvider.AVAILABLE:
                    Log.i(TAG, "AVAILABLE");
                    break;
                case LocationProvider.OUT_OF_SERVICE:
                    Log.i(TAG, "OUT_OF_SERVICE");
                    break;
                case LocationProvider.TEMPORARILY_UNAVAILABLE:
                    Log.i(TAG, "TEMPORARILY_UNAVAILABLE");
                    break;
            }
        }

        @Override
        public void onProviderEnabled(String provider) {
            Log.d(TAG, "onProviderEnabled() called with " + "provider = [" + provider + "]");
            try {
                Location location = locationManager.getLastKnownLocation(provider);
                Log.d(TAG, "onProviderDisabled.location = " + location);
                updateView(location);
            } catch (SecurityException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onProviderDisabled(String provider) {
            Log.d(TAG, "onProviderDisabled() called with " + "provider = [" + provider + "]");
        }
    };

    private void updateView(Location location){
        Geocoder geocoder = new Geocoder(this);
        List<Address> addressList = null;
        String msg = "";
        Log.d(TAG, "updateView.location = " + location);
        if (location != null) {
            try {
                addressList = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                Log.d(TAG, "updateView.addressList = " + addressList);
                if (addressList.size() > 0) {
                    msg += addressList.get(0).getAdminArea();
                    msg += " " + addressList.get(0).getLocality();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            editText.setText("Location position: \n");
            editText.append(msg);
            editText.append("\n Longitude: ");
            editText.append(String.valueOf(location.getLongitude()));
            editText.append("\n Latitude: ");
            editText.append(String.valueOf(location.getLatitude()));
        } else {
            editText.getEditableText().clear();
            editText.setText("Locating...");
        }
    }


}
