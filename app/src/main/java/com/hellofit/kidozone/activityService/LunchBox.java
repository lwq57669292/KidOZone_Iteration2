package com.hellofit.kidozone.activityService;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hellofit.kidozone.R;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class LunchBox extends AppCompatActivity {


    private float downX;
    private float downY;
    private int i;
    private int count;
    private Bundle bundle = new Bundle();
    private ArrayList<String> pickList = new ArrayList<String>();
    //private ArrayList<String> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lunch_box);

        Button goResult = (Button) findViewById(R.id.finish);

        goResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LunchBox.this, LunchBoxResult.class);
                bundle.putStringArrayList("pickItemList",pickList);
                intent.putExtras(bundle);
                startActivityForResult(intent, 1);
            }
        });

        Button backButton = (Button) findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LunchBox.this, MainActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        ImageView imageView = (ImageView) findViewById(R.id.Food);
        Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
        imageView.startAnimation(shake);

        i = 0;
        count=0;
        TextView textView1 = (TextView) findViewById(R.id.count);
        textView1.setText(count+"/6");

        String[] foodName = {"Banana", "Beef", "Cherries", "Chicken", "Cake", "Cola","Corn","Egg","Fresh Juice","Lettuce"};
        int[] imageSoursFood = {R.drawable.banana, R.drawable.beef, R.drawable.cherries, R.drawable.chicken,R.drawable.cake,R.drawable.cola,R.drawable.corn,R.drawable.egg,R.drawable.fresh_juice,R.drawable.lettuce};
        TextView textView = (TextView) findViewById(R.id.foodName);
        textView.setText(foodName[i]);
        imageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), imageSoursFood[i]));





    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        String action = "";

        ImageView imageView = (ImageView) findViewById(R.id.Food);
        int[] imageSoursFood = {R.drawable.banana, R.drawable.beef, R.drawable.cherries, R.drawable.chicken,R.drawable.cake,R.drawable.cola,R.drawable.corn,R.drawable.egg,R.drawable.fresh_juice,R.drawable.lettuce};
        TextView textView = (TextView) findViewById(R.id.foodName);
        String[] foodName = {"Banana", "Beef", "Cherries", "Chicken", "Cake", "Cola","Corn","Egg","Fresh Juice","Lettuce"};




        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:


                downX = x;
                downY = y;
                Log.e("Tag", "=======PressX：" + x);
                Log.e("Tag", "=======PressY：" + y);
                break;
            case MotionEvent.ACTION_UP:
                Log.e("Tag", "=======PressX：" + x);
                Log.e("Tag", "=======PressY：" + y);


                float dx = x - downX;
                float dy = y - downY;

                Log.e("Tag", "========X axis Distance：" + dx);
                Log.e("Tag", "========Y axis Distance：" + dy);
                if (Math.abs(dx) > 300 || Math.abs(dy) > 300) {


                    MediaPlayer mp = MediaPlayer.create(LunchBox.this, R.raw.shoop);
                    mp.start();
                    int orientation = getOrientation(dx, dy);
                    if (count < 6) {
                        if (orientation == 'r') {
                            Toast toast = Toast.makeText(LunchBox.this, "Added to the lunchBox!", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();
                            pickList.add(String.valueOf(i));
                            if (i < 9) {
                                i++;
                            }
                            imageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), imageSoursFood[i]));
                            textView.setText(foodName[i]);
                            count++;
                            TextView textView1 = (TextView) findViewById(R.id.count);
                            textView1.setText(count + "/6");
                        } else {
                            Toast toast1 = Toast.makeText(LunchBox.this, "Looks like u dont like it!", Toast.LENGTH_SHORT);
                            toast1.setGravity(Gravity.CENTER, 0, 0);
                            toast1.show();
                            if (i < 9) {
                                i++;
                            }
                            imageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), imageSoursFood[i]));
                            textView.setText(foodName[i]);

                        }
                        // Display display = getWindowManager().getDefaultDisplay();
                        //   int height = display.getHeight();
                        //  Toast toast = Toast.makeText(LunchBox.this, "", Toast.LENGTH_SHORT);
                        // toast.setGravity(Gravity.TOP, 0, 5 * (height / 8));
                        //   toast.show();
                    }else{
                        Toast toast1 = Toast.makeText(LunchBox.this, "Your already pick 6,submit and see the score!", Toast.LENGTH_SHORT);
                        toast1.setGravity(Gravity.CENTER, 0, 0);
                        toast1.show();
                       // Intent intent1 = new Intent(LunchBox.this, LunchBoxResult.class);
                        //startActivity(intent1);
                    }
                }
                break;
        }
        return super.onTouchEvent(event);
    }


    private int getOrientation(float dx, float dy) {

        if (Math.abs(dx) > Math.abs(dy)) {
            //X axis move
            return dx > 0 ? 'r' : 'l';
        } else {
            //Y axis move
            return dy > 0 ? 'b' : 't';
        }
    }


}

