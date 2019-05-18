package com.divine.appwisata.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Rizal Hilman on 12/02/18.
 * www.khilman.com
 */

public class InitRetrofit {
    // URL Server API
    public static String API_URL = "https://yahyaproject.000webhostapp.com/";

    public static Retrofit setInit() {
        return new Retrofit.Builder().baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiServices getInstance() {
        return setInit().create(ApiServices.class);
    }
}