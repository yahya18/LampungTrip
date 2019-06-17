package com.divine.appwisata.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.divine.appwisata.R;
import com.divine.appwisata.adapter.AdapterWisata;
import com.divine.appwisata.network.ApiServices;
import com.divine.appwisata.network.InitRetrofit;
import com.divine.appwisata.response.ResponseWisata;
import com.divine.appwisata.response.WisataItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FindPlaceActivity extends AppCompatActivity {

    // Deklarasi
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_place);
        // Inisialisasi
        recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        // RecyclerView harus pakai Layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // Eksekusi method
        tampilWisata();
    }

    private void tampilWisata() {
        ApiServices api = InitRetrofit.getInstance();
        // Siapkan request
        Call<ResponseWisata> wisataCall = api.request_show_all_wisata();
        // Kirim request
        wisataCall.enqueue(new Callback<ResponseWisata>() {
            @Override
            public void onResponse(Call<ResponseWisata> call, Response<ResponseWisata> response) {
                // Pasikan response Sukses
                if (response.isSuccessful()) {
                    Log.d("response api", response.body().toString());
                    // tampung data response body ke variable
                    List<WisataItem> data_wisata = response.body().getWisata();
                    boolean status = response.body().isStatus();
                    // Kalau response status nya = true
                    if (status) {
                        // Buat Adapter untuk recycler view
                        AdapterWisata adapter = new AdapterWisata(FindPlaceActivity.this, data_wisata);
                        recyclerView.setAdapter(adapter);
                    } else {
                        // kalau tidak true
                        Toast.makeText(FindPlaceActivity.this, "Tidak ada tempat wisata untuk saat ini", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseWisata> call, Throwable t) {
                // print ke log jika Error
                t.printStackTrace();
            }
        });
    }
}
