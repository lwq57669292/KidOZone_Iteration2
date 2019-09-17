package com.hellofit.kidozone.activityService;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.hellofit.kidozone.R;
import com.hellofit.kidozone.common.RestClient;
import com.hellofit.kidozone.common.SystemUtil;
import com.hellofit.kidozone.entity.FoodInfo;
import com.hellofit.kidozone.entity.WasteInfo;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // The list to contain the food entity which using in the game
    private ArrayList<FoodInfo> foodInfos;
    // The list to contain the waste entity which using in the game
    private ArrayList<WasteInfo> wasteInfos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        foodInfos = new ArrayList<FoodInfo>();
        wasteInfos = new ArrayList<WasteInfo>();

        Button buttonLunch = (Button) findViewById(R.id.LunchGame);

        buttonLunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, LunchBox.class);
                SharedPreferences.Editor editor = getSharedPreferences("SystemSP", MODE_PRIVATE).edit();
                Gson gson = new Gson();
                String json = gson.toJson(foodInfos);
                editor.putString("foodList", json);
                editor.commit();
                startActivityForResult(intent, 1);
            }
        });

        ImageButton imageLunch = (ImageButton) findViewById(R.id.imageLunchGame);

        imageLunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LunchBox.class);
                SharedPreferences.Editor editor = getSharedPreferences("SystemSP", MODE_PRIVATE).edit();
                Gson gson = new Gson();
                String json = gson.toJson(foodInfos);
                editor.putString("foodList", json);
                editor.commit();
                startActivity(intent);
            }
        });

        Button buttonWaste = (Button) findViewById(R.id.WasteGame);

        buttonWaste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, Waste.class);
                SharedPreferences.Editor editor = getSharedPreferences("SystemSP", MODE_PRIVATE).edit();
                Gson gson = new Gson();
                String json = gson.toJson(wasteInfos);
                editor.putString("wasteList", json);
                editor.commit();
                startActivityForResult(intent, 1);
            }
        });

        ImageButton imageWaste = (ImageButton) findViewById(R.id.imageWasteGame);

        imageWaste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Waste.class);
                SharedPreferences.Editor editor = getSharedPreferences("SystemSP", MODE_PRIVATE).edit();
                Gson gson = new Gson();
                String json = gson.toJson(wasteInfos);
                editor.putString("wasteList", json);
                editor.commit();
                startActivityForResult(intent, 1);
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

        GetFoodEntityAsyncTask gfe = new GetFoodEntityAsyncTask();
        gfe.execute();
        GetWasteEntityAsyncTask gwe = new GetWasteEntityAsyncTask();
        gwe.execute();

    }

    private class GetFoodEntityAsyncTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            foodInfos = RestClient.parseFoodJson(RestClient.getRandomFood());
            return null;
        }
    }

    private class GetWasteEntityAsyncTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            wasteInfos = RestClient.parseWasteJson(RestClient.getRandomWaste());
            return null;
        }
    }


}
