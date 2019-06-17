package com.divine.appwisata.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.divine.appwisata.R;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    // Deklarasi
    ImageView gambarPoster;
    TextView subW;
    WebView wvKontenBerita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Ditambahkan Ke Favorite", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // Inisialisasi
        gambarPoster = (ImageView) findViewById(R.id.gambarPoster);
        subW = (TextView) findViewById(R.id.subW);
        wvKontenBerita = (WebView) findViewById(R.id.wvKontenBerita);

        // Jalankan method tampil detail berita
        showDetailWisata();

    }

    private void showDetailWisata() {
        // Tangkap data dari intent
        String nama_tmpt = getIntent().getStringExtra("NAMA_TMPT");
        String sub_nama = getIntent().getStringExtra("SUB_NAMA");
        String isi_ket = getIntent().getStringExtra("ISI_KET");
        String foto = getIntent().getStringExtra("FTO_WISATA");

        // Set judul actionbar / toolbar
        getSupportActionBar().setTitle(nama_tmpt);


        // Untuk gambar berita
        Picasso.with(this).load(foto).into(gambarPoster);



        // Set isi berita sebagai html ke WebView
        wvKontenBerita.getSettings().setJavaScriptEnabled(true);
        wvKontenBerita.loadData(isi_ket, "text/html; charset=utf-8", "UTF-8");
    }
}
