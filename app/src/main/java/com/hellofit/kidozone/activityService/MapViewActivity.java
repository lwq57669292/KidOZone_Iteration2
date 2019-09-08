package com.hellofit.kidozone.activityService;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.hellofit.kidozone.R;

/***
 * The Activity for the first view to display the map to the user
 *
 */
public class MapViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_view_activity);
    }
}
