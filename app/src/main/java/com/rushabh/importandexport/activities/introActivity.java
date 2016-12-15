package com.rushabh.importandexport.activities;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rushabh.importandexport.R;

public class introActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Introduction");


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
    }
}
