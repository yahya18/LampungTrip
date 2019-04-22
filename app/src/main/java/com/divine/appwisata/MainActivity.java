package com.divine.appwisata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {
    Button buttonmaps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonmaps = (Button) findViewById(R.id.buttonmaps);
        buttonmaps.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent MapsIntent = new Intent(MainActivity.this, MenuMapActivity.class);
        startActivity(MapsIntent);

    }
}
