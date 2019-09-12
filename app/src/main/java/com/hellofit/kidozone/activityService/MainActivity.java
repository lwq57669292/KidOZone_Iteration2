package com.hellofit.kidozone.activityService;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.hellofit.kidozone.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonLunch = (Button) findViewById(R.id.buttonLunch);

        buttonLunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, LunchBox.class);
                startActivityForResult(intent, 1);
            }
        });

        Button buttonWaste = (Button) findViewById(R.id.buttonWaste);

        buttonWaste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, Waste.class);
                startActivityForResult(intent, 1);
            }
        });

        Button buttonStory = (Button) findViewById(R.id.buttonStory);

        buttonStory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, Story.class);
                startActivityForResult(intent, 1);
            }
        });

    }



}
