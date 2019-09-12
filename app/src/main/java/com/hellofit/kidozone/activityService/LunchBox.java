package com.hellofit.kidozone.activityService;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hellofit.kidozone.R;

import androidx.appcompat.app.AppCompatActivity;

public class LunchBox extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lunch_box);

        Button goResult = (Button) findViewById(R.id.finish);

        goResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(LunchBox.this, LunchBoxResult.class);
                startActivityForResult(intent, 1);
            }
        });

    }
}

