package com.divine.appwisata.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.divine.appwisata.R;
import com.divine.appwisata.response.WisataItem;
import com.divine.appwisata.view.DetailActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.MyViewHolder> {
    // Buat Global variable untuk manampung context
    Context context;
    List<WisataItem> wisata;
    public FavoriteAdapter(Context context, List<WisataItem> data_wisata) {
        // Inisialisasi
        this.context = context;
        this.wisata = data_wisata;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(context);
        view = mInflater.inflate(R.layout.favorite_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FavoriteAdapter.MyViewHolder holder, final int position) {
        // Set widget
        holder.judulWisata.setText(wisata.get(position).getNamaTempat());
        holder.subW.setText(wisata.get(position).getSubNama());

        // Dapatkan url gambar
        final String urlGambarWisata = "https://yahyaproject.000webhostapp.com/images/" + wisata.get(position).getFoto();
        // Set image ke widget dengna menggunakan Library Piccasso
        // krena imagenya dari internet
        Picasso.with(context).load(urlGambarWisata).into(holder.gambarPoster);

        // Event klik ketika item list nya di klik
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Mulai activity Detail
                Intent varIntent = new Intent(context, DetailActivity.class);
                // sisipkan data ke intent
                varIntent.putExtra("NAMA_TMPT", wisata.get(position).getNamaTempat());
                varIntent.putExtra("SUB_NAMA", wisata.get(position).getSubNama());
                varIntent.putExtra("FTO_WISATA", urlGambarWisata);
                varIntent.putExtra("ISI_KET", wisata.get(position).getIsiKeterangan());

                // method startActivity cma bisa di pake di activity/fragment
                // jadi harus masuk ke context dulu
                context.startActivity(varIntent);
            }
        });
    }
    // Menentukan Jumlah item yang tampil
    @Override
    public int getItemCount() {
        return wisata.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // Deklarasi widget
        ImageView gambarPoster;
        TextView judulWisata, subW;
        TextView deskrip;

        public MyViewHolder(View itemView) {
            super(itemView);
            // inisialisasi widget
            gambarPoster = (ImageView) itemView.findViewById(R.id.gambarPoster);
            judulWisata = (TextView) itemView.findViewById(R.id.judulWisata);
            subW = (TextView) itemView.findViewById(R.id.subW);
            deskrip = (TextView) itemView.findViewById(R.id.deskrip);
        }
    }
}
