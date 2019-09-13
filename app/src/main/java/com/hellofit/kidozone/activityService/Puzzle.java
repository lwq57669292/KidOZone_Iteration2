package com.hellofit.kidozone.activityService;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.hellofit.kidozone.R;

import androidx.appcompat.app.AppCompatActivity;

public class Puzzle extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.puzzle);

        ImageButton imageAnimal = (ImageButton) findViewById(R.id.imageAnimal);

        imageAnimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Puzzle.this, PuzzleAnimal.class);
                startActivity(intent);
            }
        });

        Button animal = (Button) findViewById(R.id.animal);

        animal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Puzzle.this, PuzzleAnimal.class);
                startActivity(intent);
            }
        });

        ImageButton imageSport = (ImageButton) findViewById(R.id.imageSport);

        imageSport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Puzzle.this, PuzzleSport.class);
                startActivity(intent);
            }
        });

        Button sport = (Button) findViewById(R.id.sport);

        sport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Puzzle.this, PuzzleSport.class);
                startActivity(intent);
            }
        });


        ImageButton imageView = (ImageButton) findViewById(R.id.imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Puzzle.this, PuzzleView.class);
                startActivity(intent);
            }
        });

        Button view = (Button) findViewById(R.id.View);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Puzzle.this, PuzzleView.class);
                startActivity(intent);
            }
        });




    }


}

