package com.prathamesh.attendancetaker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    ImageView IV_Splash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IV_Splash = findViewById(R.id.IV_Splash);

        Glide.with(this).load(R.drawable.checklist).into(IV_Splash);
    }
}