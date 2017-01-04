package com.example.ckz.imagetest;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;

public class Main4Activity extends AppCompatActivity {
    private ImageView gif_image;
    private Button start,pause;
    private AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        gif_image = (ImageView) findViewById(R.id.gif_image);
        start = (Button) findViewById(R.id.btn_start);
        pause = (Button) findViewById(R.id.btn_pasue);
        animationDrawable = (AnimationDrawable) gif_image.getBackground();

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!animationDrawable.isRunning()){
                    animationDrawable.start();
                }
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (animationDrawable.isRunning()){
                    animationDrawable.stop();
                }
            }
        });
    }
}
