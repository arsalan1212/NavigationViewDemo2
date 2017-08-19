package com.example.arsalankhan.navigationviewdemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;
    private Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("Navigation View");

        SetUpNevigationView();
    }

    private void SetUpNevigationView() {

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);


        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout,mToolbar,
                R.string.open_drawer,R.string.close_drawer);

        mDrawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();


        navigationView.setNavigationItemSelectedListener(this);
    }

private void openDrawer(){
    mDrawerLayout.openDrawer(GravityCompat.START);
}

    private void closeDrawer() {
        mDrawerLayout.closeDrawer(GravityCompat.START);
    }


    @Override
    public void onBackPressed() {
        if(mDrawerLayout.isDrawerOpen(GravityCompat.START)){

            closeDrawer();
        }
        else{
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        String title = item.getTitle().toString();

        closeDrawer();

        Toast.makeText(this, "Click On: "+title, Toast.LENGTH_SHORT).show();

        switch (item.getItemId()){
            case R.id.facebook:
                break;
            case R.id.twitter:
                break;

        }
        return false;
    }
}
