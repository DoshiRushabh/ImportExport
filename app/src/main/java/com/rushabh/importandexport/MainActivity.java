package com.rushabh.importandexport;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rushabh.importandexport.activities.CurrencyConverter;
import com.rushabh.importandexport.fragments.MainFragment;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView title;
    ImageView shareImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        shareImage = (ImageView) findViewById(R.id.shareImage);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("");

        title = (TextView) findViewById(R.id.title);
        title.setTextSize(20);

        title.setTranslationY(-(600));
        title.animate()
                .translationY(0)
                .setDuration(500)
                .setStartDelay(500);


        toolbar.setTranslationY(-(500));
        toolbar.animate()
                .translationY(0)
                .setDuration(500)
                .setStartDelay(300);

        shareImage.setTranslationY(-(700));
        shareImage.animate()
                .translationY(0)
                .setDuration(500)
                .setStartDelay(700);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.MainLayout, new MainFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.currancyconverter) {
            startActivity(new Intent(MainActivity.this, CurrencyConverter.class));
        } else if (id == R.id.rateapp) {

        } else if (id == R.id.feedback) {

        } else if (id == R.id.aboutus) {

        } else if (id == R.id.contactus) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
