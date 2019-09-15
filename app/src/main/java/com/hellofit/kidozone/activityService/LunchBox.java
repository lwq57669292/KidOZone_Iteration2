package com.hellofit.kidozone.activityService;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hellofit.kidozone.R;

import androidx.appcompat.app.AppCompatActivity;

public class LunchBox extends AppCompatActivity {


    private float downX ;
    private float downY ;

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

        Button backButton = (Button) findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(LunchBox.this, MainActivity.class);
                startActivityForResult(intent, 1);
            }
        });

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        String action = "";

        float x= event.getX();
        float y = event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:


                downX = x;
                downY = y;
                Log.e("Tag","=======PressX："+x);
                Log.e("Tag","=======PressY："+y);
                break;
            case MotionEvent.ACTION_UP:
                Log.e("Tag","=======PressX："+x);
                Log.e("Tag","=======PressY："+y);


                float dx= x-downX;
                float dy = y-downY;

                Log.e("Tag","========X axis Distance："+dx);
                Log.e("Tag","========Y axis Distance："+dy);
                if (Math.abs(dx)>300||Math.abs(dy)>300) {

                    int orientation = getOrientation(dx, dy);
                    switch (orientation) {
                        case 'r':
                            Toast.makeText(LunchBox.this, "Added to the lunchBox!", Toast.LENGTH_SHORT).show();
                            break;
                        case 'l':
                            Toast.makeText(LunchBox.this, "Looks like u dont like it!", Toast.LENGTH_SHORT).show();
                            break;
                    }
                   // Display display = getWindowManager().getDefaultDisplay();
                 //   int height = display.getHeight();
                  //  Toast toast = Toast.makeText(LunchBox.this, "", Toast.LENGTH_SHORT);
                   // toast.setGravity(Gravity.TOP, 0, 5 * (height / 8));
                 //   toast.show();
                }
                break;
        }
        return super.onTouchEvent(event);
    }


    private int getOrientation(float dx, float dy) {

        if (Math.abs(dx)>Math.abs(dy)){
            //X axis move
            return dx>0?'r':'l';
        }else{
            //Y axis move
            return dy>0?'b':'t';
        }
    }


}

