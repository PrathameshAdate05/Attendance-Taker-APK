package com.prathamesh.attendancetaker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Splash extends AppCompatActivity {

    ImageView IV_Splash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        IV_Splash = findViewById(R.id.IV_Splash);

        Glide.with(this).load(R.drawable.checklist).into(IV_Splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this,Home.class);
                startActivity(intent);
                finish();
            }
        }, Constants.SPLASH_TIME);
    }
}