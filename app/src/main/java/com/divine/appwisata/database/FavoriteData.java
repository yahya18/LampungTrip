package com.divine.appwisata.database;

import android.provider.BaseColumns;

public class FavoriteData {

    public static class FavoriteInput implements BaseColumns {
        public static final String TB_NAMA = "tb_favorite";
        public static final String COL_ID = "fav_id";
        public static final String COL_NAMA = "NAMA_TMPT";
        public static final String COL_SUB = "SUB_NAMA";
        public static final String COL_FOTO = "FTO_WISATA";
        public static final String COL_KONTEN = "ISI_KET";

    }
}
