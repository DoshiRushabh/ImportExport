package com.rushabh.importandexport.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rushabh.importandexport.MainActivity;
import com.rushabh.importandexport.R;

public class splashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        getSupportActionBar().hide();

        Thread welcomeThread = new Thread() {

            @Override
            public void run() {
                try {
                    super.run();
                    sleep(10000);  //Delay of 10 seconds
                } catch (Exception e) {

                } finally {
                    startActivity(new Intent(splashScreenActivity.this,
                            MainActivity.class));
                    finish();
                }
            }
        };
        welcomeThread.start();
    }
}
