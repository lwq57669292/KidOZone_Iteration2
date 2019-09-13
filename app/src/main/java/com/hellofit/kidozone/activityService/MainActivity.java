package com.hellofit.kidozone.activityService;

import android.content.Intent;
import android.os.Bundle;

import com.hellofit.kidozone.R;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
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
                Intent intent = new Intent(MainActivity.this, Puzzle.class);
                startActivityForResult(intent, 1);
            }
        });

    }



}
