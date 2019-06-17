package com.divine.appwisata.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import com.divine.appwisata.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    CardView buttonfineplace;
    CardView buttonmaps;
    CardView buttonabout;
    CardView buttonfavorite;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonfineplace =(CardView) findViewById(R.id.buttonfineplace);
        buttonfineplace.setOnClickListener(this);

        buttonmaps = (CardView) findViewById(R.id.buttonmaps);
        buttonmaps.setOnClickListener(this);

        buttonabout = (CardView) findViewById(R.id.buttonabout);
        buttonabout.setOnClickListener(this);

        buttonfavorite = (CardView) findViewById(R.id.buttonfavorite);
        buttonfavorite.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonfineplace:
                Intent Place = new Intent(MainActivity.this, FindPlaceActivity.class);
                startActivity(Place);
                break;

            case R.id.buttonmaps:
                Intent MapsIntent = new Intent(MainActivity.this, MenuMapActivity.class);
                startActivity(MapsIntent);
                break;

            case R.id.buttonabout:
                Intent about = new Intent(MainActivity.this, TentangActivity.class);
                startActivity(about);
                break;

            case R.id.buttonfavorite:
                Intent favorit = new Intent(MainActivity.this, FavoriteActivity.class);
                startActivity(favorit);
                break;
        }
    }
}
