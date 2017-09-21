package io.github.erikcaffrey.ayudamexico.hospitals.model;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

abstract class HospitalRetrofitClient {

    private final static String URL = "https://script.google.com/";
    final static String HELP_URL = "https://script.google.com/macros/s/AKfycbwlzrFODKifA5zevwHEJ-2gDhhrctvCat4wk5cPa_du0XCMVfr5/exec";
    private HospitalRetrofitService hospitalRetrofitService;

    HospitalRetrofitClient() {
        initRetrofit();
    }

    private void initRetrofit() {
        Retrofit retrofit = retrofitBuilder();
        hospitalRetrofitService = retrofit.create(getServiceClass());
    }

    private Retrofit retrofitBuilder() {
        return new Retrofit.Builder().baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(getOkHttpClient())
            .build();
    }

    private OkHttpClient getOkHttpClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);
        return httpClient.build();
    }

    private Class<HospitalRetrofitService> getServiceClass() {
        return HospitalRetrofitService.class;
    }

    protected HospitalRetrofitService getService() {
        return hospitalRetrofitService;
    }
}