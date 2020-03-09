package com.raj.safex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;



public class SplashActivity extends AppCompatActivity {
    int splashTime = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        SharedPreferences sharedPreferences = getSharedPreferences("MyApp",MODE_PRIVATE);
        final String strEmail = sharedPreferences.getString("PHONE_NO","");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (strEmail.equals("")){

                    Intent i = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();

                }else {

                    Intent i = new Intent(SplashActivity.this, NavDrawerMain.class);
                    startActivity(i);
                    finish();

                }

            }
        },splashTime);
    }
}
