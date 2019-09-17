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
import android.widget.TextView;

import com.hellofit.kidozone.R;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class LunchBoxResult extends AppCompatActivity {

    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lunch_result);

        Button backButton = (Button) findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LunchBoxResult.this, LunchBox.class);
                startActivityForResult(intent, 1);
            }
        });

        score = 100;
        ImageView imageView1 = (ImageView) findViewById(R.id.imageFood1);
        ImageView imageView2 = (ImageView) findViewById(R.id.imageFood2);
        ImageView imageView3 = (ImageView) findViewById(R.id.imageFood3);
        ImageView imageView4 = (ImageView) findViewById(R.id.imageFood4);
        ImageView imageView5 = (ImageView) findViewById(R.id.imageFood5);
        ImageView imageView6 = (ImageView) findViewById(R.id.imageFood6);

        int[] imageSoursFood = {R.drawable.banana, R.drawable.beef, R.drawable.cherries, R.drawable.chicken, R.drawable.cake, R.drawable.cola, R.drawable.corn, R.drawable.egg, R.drawable.fresh_juice, R.drawable.lettuce};
        String[] foodCategory = {"fruit", "meat", "fruit", "meat", "dessert", "junkFood", "vegetable", "meat", "juice", "vegetable"};


        Bundle bundle = getIntent().getExtras();
        ArrayList<String> test = bundle.getStringArrayList("pickItemList");
        int listsize = test.size();
        switch (listsize) {
            case 1:
                imageView1.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), imageSoursFood[Integer.parseInt(test.get(0))]));
                if (foodCategory[Integer.parseInt(test.get(0))].equals("junkFood")) {
                    score = score - 10;
                }
                break;
            case 2:
                imageView1.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), imageSoursFood[Integer.parseInt(test.get(0))]));
                imageView2.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), imageSoursFood[Integer.parseInt(test.get(1))]));
                for (int i = 0; i < 2; i++) {
                    if (foodCategory[Integer.parseInt(test.get(i))].equals("junkFood")) {
                        score = score - 10;
                    }
                }
                if (foodCategory[Integer.parseInt(test.get(0))] == foodCategory[Integer.parseInt(test.get(1))]) {
                    score = score - 10;
                }
                break;
            case 3:
                imageView1.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), imageSoursFood[Integer.parseInt(test.get(0))]));
                imageView2.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), imageSoursFood[Integer.parseInt(test.get(1))]));
                imageView3.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), imageSoursFood[Integer.parseInt(test.get(2))]));
                List<String> newList = new ArrayList<String>();
                for (int i = 0; i < 3; i++) {
                    if (!newList.contains(foodCategory[Integer.parseInt(test.get(i))])) {
                        newList.add(foodCategory[Integer.parseInt(test.get(i))]);
                    }
                    if (foodCategory[Integer.parseInt(test.get(i))].equals("junkFood")) {
                        score = score - 10;
                    }
                }
                score = score - 10 * (3 - newList.size());
                break;
            case 4:
                imageView1.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), imageSoursFood[Integer.parseInt(test.get(0))]));
                imageView2.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), imageSoursFood[Integer.parseInt(test.get(1))]));
                imageView3.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), imageSoursFood[Integer.parseInt(test.get(2))]));
                imageView4.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), imageSoursFood[Integer.parseInt(test.get(3))]));
                List<String> newList1 = new ArrayList<String>();
                for (int i = 0; i < 4; i++) {
                    if (!newList1.contains(foodCategory[Integer.parseInt(test.get(i))])) {
                        newList1.add(foodCategory[Integer.parseInt(test.get(i))]);
                    }
                    if (foodCategory[Integer.parseInt(test.get(i))].equals("junkFood")) {
                        score = score - 10;
                    }
                }
                score = score - 10 * (4 - newList1.size());
                break;
            case 5:
                imageView1.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), imageSoursFood[Integer.parseInt(test.get(0))]));
                imageView2.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), imageSoursFood[Integer.parseInt(test.get(1))]));
                imageView3.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), imageSoursFood[Integer.parseInt(test.get(2))]));
                imageView4.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), imageSoursFood[Integer.parseInt(test.get(3))]));
                imageView5.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), imageSoursFood[Integer.parseInt(test.get(4))]));
                List<String> newList2 = new ArrayList<String>();
                for (int i = 0; i < 5; i++) {
                    if (!newList2.contains(foodCategory[Integer.parseInt(test.get(i))])) {
                        newList2.add(foodCategory[Integer.parseInt(test.get(i))]);
                    }
                    if (foodCategory[Integer.parseInt(test.get(i))].equals("junkFood")) {
                        score = score - 10;
                    }
                }
                score = score - 10 * (5 - newList2.size());
                break;
            case 6:
                imageView1.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), imageSoursFood[Integer.parseInt(test.get(0))]));
                imageView2.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), imageSoursFood[Integer.parseInt(test.get(1))]));
                imageView3.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), imageSoursFood[Integer.parseInt(test.get(2))]));
                imageView4.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), imageSoursFood[Integer.parseInt(test.get(3))]));
                imageView5.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), imageSoursFood[Integer.parseInt(test.get(4))]));
                imageView6.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), imageSoursFood[Integer.parseInt(test.get(5))]));
                List<String> newList3 = new ArrayList<String>();
                for (int i = 0; i < 6; i++) {
                    if (!newList3.contains(foodCategory[Integer.parseInt(test.get(i))])) {
                        newList3.add(foodCategory[Integer.parseInt(test.get(i))]);
                    }
                    if (foodCategory[Integer.parseInt(test.get(i))].equals("junkFood")) {
                        score = score - 10;
                    }
                }
                score = score - 10 * (6 - newList3.size());
                break;
        }

        TextView textView = (TextView) findViewById(R.id.textResult);
        TextView textView1 = (TextView) findViewById(R.id.textResultExplain);
        textView.setText("Your score is: " + score);
        if (score >= 80) {
            textView1.setText(("Great lunchbox!"));
        }
        if ((score < 80) && (score >= 60)) {
            textView1.setText(("Good, maybe can better more."));
        }
        if (score < 60) {
            textView1.setText(("You can have a more healthy lunchbox."));
        }


    }


}