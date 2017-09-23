package io.github.erikcaffrey.ayudamexico.donations.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by armando on 9/22/17.
 */

public class DonationRetrofitClient {

    private static final String ROOT_URL = "https://raw.githubusercontent.com/erikcaffrey/AyudaMexico/iss23/json/";

    /**
     * Get Retrofit Instance
     */
    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * Get API Service
     *
     * @return API Service
     */
    public static DonationsRetrofitService getApiService() {
        return getRetrofitInstance().create(DonationsRetrofitService.class);
    }

}
