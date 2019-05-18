package com.divine.appwisata.network;

import com.divine.appwisata.response.ResponseWisata;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Rizal Hilman on 12/02/18.
 * www.khilman.com
 */

public interface ApiServices {

    //@TIPEMETHOD("API_END_POINT")
    @GET("tampil_wisata.php")
    Call<ResponseWisata> request_show_all_wisata();
    // <ModelData> nama_method()

}