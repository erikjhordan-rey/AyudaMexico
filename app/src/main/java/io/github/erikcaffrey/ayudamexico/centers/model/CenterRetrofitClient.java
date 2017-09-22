package io.github.erikcaffrey.ayudamexico.centers.model;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

abstract class CenterRetrofitClient {

    private final static String URL = "https://script.google.com/";
    final static String HELP_URL = "https://script.google.com/macros/s/AKfycbyTY_1P9g9t5qnTT3YLbTaPk5CuWSiVXputqbZCxTEXNJfFUFQ/exec";
    private CenterRetrofitService centerRetrofitService;

    CenterRetrofitClient() {
        initRetrofit();
    }

    private void initRetrofit() {
        Retrofit retrofit = retrofitBuilder();
        centerRetrofitService = retrofit.create(getServiceClass());
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

    private Class<CenterRetrofitService> getServiceClass() {
        return CenterRetrofitService.class;
    }

    protected CenterRetrofitService getService() {
        return centerRetrofitService;
    }
}