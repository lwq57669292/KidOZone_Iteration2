package com.hellofit.kidozone.activityService;

import android.content.Intent;
import android.os.Bundle;

import com.hellofit.kidozone.R;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonLunch = (Button) findViewById(R.id.LunchGame);

        buttonLunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, LunchBox.class);
                startActivityForResult(intent, 1);
            }
        });

        ImageButton imageLunch = (ImageButton) findViewById(R.id.imageLunchGame);

        imageLunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LunchBox.class);
                startActivity(intent);
            }
        });

        Button buttonWaste = (Button) findViewById(R.id.WasteGame);

        buttonWaste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, Waste.class);
                startActivityForResult(intent, 1);
            }
        });

        ImageButton imageWaste = (ImageButton) findViewById(R.id.imageWasteGame);

        imageWaste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Waste.class);
                startActivity(intent);
            }
        });

        Button buttonPuzzle = (Button) findViewById(R.id.PuzzleGame);

        buttonPuzzle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, Puzzle.class);
                startActivityForResult(intent, 1);
            }
        });

        ImageButton imagePuzzle = (ImageButton) findViewById(R.id.imagePuzzleGame);

        imagePuzzle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Puzzle.class);
                startActivity(intent);
            }
        });

    }



}
