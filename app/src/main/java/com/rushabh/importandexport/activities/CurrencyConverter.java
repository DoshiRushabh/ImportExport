package com.rushabh.importandexport.activities;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Spinner;
import android.widget.Toast;

import com.rushabh.importandexport.R;
import com.rushabh.importandexport.fragments.WebViewFragment;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class CurrencyConverter extends AppCompatActivity {

    Spinner countryList1,countryList2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_converter);
        overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Currency converter");

        final Drawable upArrow = getResources().getDrawable(R.drawable.back_arrow);
        upArrow.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        actionBar.setHomeAsUpIndicator(upArrow);
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

//        countryList1 = (Spinner) findViewById(R.id.list1);
//        countryList2 = (Spinner) findViewById(R.id.list2);
//
//        addData();

//        Init web view
        WebViewFragment webViewFragment = new WebViewFragment();
        Bundle bundle = new Bundle();
        bundle.putString("url", "https://www.google.com/finance/converter?a=1&from=COP&to=BBD&meta=ei%3DfLxTWJjvAs2nuATxtK-QAw");
        webViewFragment.setArguments(bundle);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container , webViewFragment)
                .commit();
    }
    private void addData() {
        if (isNetwokAvailable()){
            String url = "http://api.fixer.io/latest?base=USD";
            RequestBody formBody = new FormBody.Builder()
                    .add("base","inr")
                    .build();

            try {
                post(url, formBody, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.e("introActivity", "IOException", e);
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String res = response.body().string();
                        Log.e("Resource" , res);
                    }
                });
            } catch (Exception e) {
                Log.e("intro Activity", "Post Exception", e);
            }
        }else{
            Toast.makeText(this, "Internet is not avalable", Toast.LENGTH_SHORT).show();
            onBackPressed();
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 0:
                onBackPressed();
                return false;
            default:
                onBackPressed();
                return true;
        }
    }
    private final OkHttpClient client = new OkHttpClient();
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
    }

    Call post(String url, RequestBody formBody, Callback callback) throws IOException {

        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
        return call;
    }
    private boolean isNetwokAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
