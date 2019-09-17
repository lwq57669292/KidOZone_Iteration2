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
import android.widget.TextView;
import android.widget.Toast;

import com.hellofit.kidozone.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class Waste extends AppCompatActivity {

    private float downX;
    private float downY;
    private int i;
    private int score;

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

        String[] wasteName = {"Banana", "Bone", "Bread", "Books", "Egg Shell", "Leaf"};
        int[] imageSoursWaste = {R.drawable.banana_1f34c, R.drawable.bone_1f9b4, R.drawable.bread, R.drawable.books, R.drawable.egg_shell, R.drawable.leaf_3};
        TextView textView = (TextView) findViewById(R.id.rubbishName);
        textView.setText(wasteName[i]);
        ImageView imageView = (ImageView) findViewById(R.id.rubbish);
        imageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), imageSoursWaste[i]));
        TextView textView1 = (TextView) findViewById(R.id.wasteScore);
        score=100;
        textView1.setText("Score: "+ score);


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        String action = "";
        String[] wasteType = {"redBin", "redBin", "redBin", "yellowBin", "redBin", "greenBin"};
        String[] wasteName = {"Banana", "Bone", "Bread", "Books", "Egg Shell", "Leaf"};
        int[] imageSoursWaste = {R.drawable.banana_1f34c, R.drawable.bone_1f9b4, R.drawable.bread, R.drawable.books, R.drawable.egg_shell, R.drawable.leaf_3};
        ImageView imageView = (ImageView) findViewById(R.id.rubbish);
        TextView textView = (TextView) findViewById(R.id.rubbishName);

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
                    if(i<6) {
                        switch (orientation) {
                            case 'r':
                                if (wasteType[i] == "yellowBin") {
                                    MediaPlayer mp1 = MediaPlayer.create(Waste.this, R.raw.great);
                                    mp1.start();
                                    Toast toast = Toast.makeText(Waste.this, "Added to the YellowBin!", Toast.LENGTH_SHORT);
                                    toast.setGravity(Gravity.BOTTOM, 0, 200);
                                    toast.show();
                                    if (i < 5) {
                                        imageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), imageSoursWaste[i + 1]));
                                        Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
                                        imageView.startAnimation(shake);
                                        textView.setText(wasteName[i + 1]);
                                        i++;
                                    }
                                    if (i == 5) {
                                        imageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), imageSoursWaste[i]));
                                        Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
                                        imageView.startAnimation(shake);
                                        textView.setText(wasteName[i]);
                                        i++;
                                    }
                                } else {
                                    MediaPlayer mp1 = MediaPlayer.create(Waste.this, R.raw.wrong);
                                    mp1.start();
                                    Toast toast = Toast.makeText(Waste.this, "Not that bin, try again.", Toast.LENGTH_SHORT);
                                    toast.setGravity(Gravity.BOTTOM, 0, 200);
                                    toast.show();
                                    score = score - 5;
                                    TextView textView1 = (TextView) findViewById(R.id.wasteScore);
                                    textView1.setText("Score: "+ score);
                                }
                                break;
                            case 'l':
                                if (wasteType[i] == "redBin") {
                                    MediaPlayer mp1 = MediaPlayer.create(Waste.this, R.raw.great);
                                    mp1.start();
                                    Toast toast = Toast.makeText(Waste.this, "Added to the RedBin!", Toast.LENGTH_SHORT);
                                    toast.setGravity(Gravity.BOTTOM, 0, 200);
                                    toast.show();
                                    if (i < 5) {
                                        imageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), imageSoursWaste[i + 1]));
                                        Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
                                        imageView.startAnimation(shake);
                                        textView.setText(wasteName[i + 1]);
                                        i++;
                                    }
                                    if (i == 5) {
                                        imageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), imageSoursWaste[i]));
                                        Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
                                        imageView.startAnimation(shake);
                                        textView.setText(wasteName[i]);
                                        i++;
                                    }
                                } else {
                                    MediaPlayer mp1 = MediaPlayer.create(Waste.this, R.raw.wrong);
                                    mp1.start();
                                    Toast toast = Toast.makeText(Waste.this, "Not that bin, try again.", Toast.LENGTH_SHORT);
                                    toast.setGravity(Gravity.BOTTOM, 0, 200);
                                    toast.show();
                                    score = score - 5;
                                    TextView textView1 = (TextView) findViewById(R.id.wasteScore);
                                    textView1.setText("Score: "+ score);
                                }
                                break;
                            case 't':
                                if (wasteType[i] == "greenBin") {
                                    MediaPlayer mp1 = MediaPlayer.create(Waste.this, R.raw.great);
                                    mp1.start();
                                    Toast toast = Toast.makeText(Waste.this, "Added to the GreenBin!", Toast.LENGTH_SHORT);
                                    toast.setGravity(Gravity.BOTTOM, 0, 200);
                                    toast.show();
                                    if (i < 5) {
                                        imageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), imageSoursWaste[i + 1]));
                                        Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
                                        imageView.startAnimation(shake);
                                        textView.setText(wasteName[i + 1]);
                                        i++;
                                    }
                                    if (i == 5) {
                                        imageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), imageSoursWaste[i]));
                                        Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
                                        imageView.startAnimation(shake);
                                        textView.setText(wasteName[i]);
                                        i++;
                                    }
                                } else {
                                    MediaPlayer mp1 = MediaPlayer.create(Waste.this, R.raw.wrong);
                                    mp1.start();
                                    Toast toast = Toast.makeText(Waste.this, "Not that bin, try again.", Toast.LENGTH_SHORT);
                                    toast.setGravity(Gravity.BOTTOM, 0, 200);
                                    toast.show();
                                    score = score - 5;
                                    TextView textView1 = (TextView) findViewById(R.id.wasteScore);
                                    textView1.setText("Score: "+ score);
                                }
                                break;
                        }
                    }else{
                        imageView.setImageDrawable(getResources().getDrawable((R.drawable.wastegameend)));
                        textView.setText("");
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
