package io.github.erikcaffrey.ayudamexico.centers.puebla.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Armando on 24/9/2017.
 */

public class CollectorCenterRetrofitClient {

    private static final String ROOT_URL = "https://cdmx.opendatasoft.com/api/records/1.0/search/";

    private static Retrofit getRetrofitInstance(){
        return new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static CollectorCenterRetrofitService getApiService(){
        return getRetrofitInstance().create(CollectorCenterRetrofitService.class);
    }
}
