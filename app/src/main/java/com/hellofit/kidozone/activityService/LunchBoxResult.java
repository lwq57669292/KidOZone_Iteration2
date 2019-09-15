package com.hellofit.kidozone.activityService;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hellofit.kidozone.R;

import androidx.appcompat.app.AppCompatActivity;

public class LunchBoxResult extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lunch_result);

        Button backButton = (Button) findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(LunchBoxResult.this, LunchBox.class);
                startActivityForResult(intent, 1);
            }
        });
    }


}