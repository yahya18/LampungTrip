package com.divine.appwisata.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.divine.appwisata.DetailActivity;
import com.divine.appwisata.R;
import com.divine.appwisata.response.WisataItem;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterWisata extends RecyclerView.Adapter<AdapterWisata.MyViewHolder> {
    // Buat Global variable untuk manampung context
    Context context;
    List<WisataItem> wisata;
    public AdapterWisata(Context context, List<WisataItem> data_wisata) {
        // Inisialisasi
        this.context = context;
        this.wisata = data_wisata;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Layout inflater
        View view = LayoutInflater.from(context).inflate(R.layout.wisata_item, parent, false);

        // Hubungkan dengan MyViewHolder
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        // Set widget
        holder.tvJudul.setText(wisata.get(position).getNamaTempat());
        holder.tvTglTerbit.setText(wisata.get(position).getSubNama());

        // Dapatkan url gambar
        final String urlGambarWisata = "https://yahyaproject.000webhostapp.com/images/" + wisata.get(position).getFoto();
        // Set image ke widget dengna menggunakan Library Piccasso
        // krena imagenya dari internet
        Picasso.with(context).load(urlGambarWisata).into(holder.ivGambarBerita);

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
        ImageView ivGambarBerita;
        TextView tvJudul, tvTglTerbit, tvPenulis;
        public MyViewHolder(View itemView) {
            super(itemView);
            // inisialisasi widget
            ivGambarBerita = (ImageView) itemView.findViewById(R.id.ivPosterBerita);
            tvJudul = (TextView) itemView.findViewById(R.id.tvJudulBerita);
            tvTglTerbit = (TextView) itemView.findViewById(R.id.tvTglTerbit);
            tvPenulis = (TextView) itemView.findViewById(R.id.tvPenulis);
        }
    }
}
