package com.divine.appwisata;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button buttonfineplace;
    Button buttonmaps;
    Button buttonabout;
    Button buttonfavorite;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonfineplace =(Button) findViewById(R.id.buttonfineplace);
        buttonfineplace.setOnClickListener(this);

        buttonmaps = (Button) findViewById(R.id.buttonmaps);
        buttonmaps.setOnClickListener(this);

        buttonabout = (Button) findViewById(R.id.buttonabout);
        buttonabout.setOnClickListener(this);

        buttonfavorite = (Button) findViewById(R.id.buttonfavorite);
        buttonfavorite.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonfineplace:
                Intent Place = new Intent(MainActivity.this, finePlace.class);
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
                Intent favorit = new Intent(MainActivity.this, PushNotif.class);
                startActivity(favorit);
                break;
        }
    }
}
