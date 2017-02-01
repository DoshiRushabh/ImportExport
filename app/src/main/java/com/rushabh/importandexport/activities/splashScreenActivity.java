package com.rushabh.importandexport.activities;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.rushabh.importandexport.MainActivity;
import com.rushabh.importandexport.R;

public class splashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.hide();

        new Thread() {

            @Override
            public void run() {
                try {
                    super.run();
                    sleep(4000);  //Delay of 2 seconds
                } catch (Exception e) {
                    Log.e("Splash screen activity","exception",e);
                } finally {
                    startActivity(new Intent(splashScreenActivity.this,
                            MainActivity.class));
                    finish();
                }
            }
        }.start();
    }
}
