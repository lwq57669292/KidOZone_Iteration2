package com.hellofit.kidozone.activityService;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.hellofit.kidozone.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class Waste extends AppCompatActivity {

    private float downX;
    private float downY;
    private int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.waste);


        Button backButton = (Button) findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Waste.this, MainActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        int[] imageSoursWaste = {R.drawable.banana_1f34c};
        ImageView imageView = (ImageView) findViewById(R.id.rubbish);
        imageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), imageSoursWaste[i]));
        Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
        imageView.startAnimation(shake);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        String action = "";
        String[] wasteType = {"greenBin"};

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

                    MediaPlayer mp = MediaPlayer.create(Waste.this, R.raw.shoop);
                    mp.start();

                    int orientation = getOrientation(dx, dy);
                    switch (orientation) {
                        case 'r':
                            if(wasteType[i]=="yellowBin") {
                                Toast toast = Toast.makeText(Waste.this, "Added to the YellowBin!", Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.BOTTOM, 0, 200);
                                toast.show();
                            }
                            else{
                                Toast toast = Toast.makeText(Waste.this, "Not that bin, try again.", Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.BOTTOM, 0, 200);
                                toast.show();
                            }
                            break;
                        case 'l':
                            if(wasteType[i]=="redBin") {
                                Toast toast = Toast.makeText(Waste.this, "Added to the RedBin!", Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.BOTTOM, 0, 200);
                                toast.show();
                            }
                            else{
                                Toast toast = Toast.makeText(Waste.this, "Not that bin, try again.", Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.BOTTOM, 0, 200);
                                toast.show();
                            }
                            break;
                        case 't':
                            if(wasteType[i]=="greenBin") {
                                Toast toast = Toast.makeText(Waste.this, "Added to the GreenBin!", Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.BOTTOM, 0, 200);
                                toast.show();
                            }
                            else{
                                Toast toast = Toast.makeText(Waste.this, "Not that bin, try again.", Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.BOTTOM, 0, 200);
                                toast.show();
                            }
                            break;
                    }
                    // Display display = getWindowManager().getDefaultDisplay();
                    //   int height = display.getHeight();
                    // Toast toast = Toast.makeText(Waste.this, "", Toast.LENGTH_SHORT);
                    // toast.setGravity(Gravity.TOP, 0, 5 * (height / 8));
                    //  toast.show();
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
