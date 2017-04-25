package com.eroticsniper;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;



public class Splash extends AppCompatActivity {
    private static final String TAG = "SplashDemo";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new CountDownTimer(3000, 1000) {
            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                Intent i = new Intent().setClass(Splash.this, LandingActivity.class);
                startActivity(i);
                finish();
            }
        }.start();
    }
}
