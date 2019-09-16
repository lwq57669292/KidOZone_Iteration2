package com.hellofit.kidozone.activityService;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.hellofit.kidozone.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

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

        ImageView imageView1 = (ImageView) findViewById(R.id.imageFood1);
        ImageView imageView2 = (ImageView) findViewById(R.id.imageFood2);
        ImageView imageView3 = (ImageView) findViewById(R.id.imageFood3);
        ImageView imageView4 = (ImageView) findViewById(R.id.imageFood4);
        ImageView imageView5 = (ImageView) findViewById(R.id.imageFood5);
        ImageView imageView6 = (ImageView) findViewById(R.id.imageFood6);


        Bundle bundle = getIntent().getExtras();
        int test = bundle.getInt("test");
        int[] imageSoursFood = {R.drawable.banana, R.drawable.beef, R.drawable.cherries, R.drawable.chicken};
        imageView1.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),imageSoursFood[test]));
        Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
        imageView1.startAnimation(shake);


    }


}