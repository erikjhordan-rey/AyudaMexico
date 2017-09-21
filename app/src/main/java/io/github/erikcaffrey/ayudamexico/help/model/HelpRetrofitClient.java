package io.github.erikcaffrey.ayudamexico.help.model;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

abstract class HelpRetrofitClient {

    private final static String URL = "https://script.google.com/";
    final static String HELP_URL = "https://script.google.com/macros/s/AKfycbzhe6RHOJqCDTgW1NLd1C_bRGJKfk4D1r2dvXLYoxeKl0Bso2L_/exec";
    private HelpRetrofitService helpRetrofitService;

    HelpRetrofitClient() {
        initRetrofit();
    }

    private void initRetrofit() {
        Retrofit retrofit = retrofitBuilder();
        helpRetrofitService = retrofit.create(getServiceClass());
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

    private Class<HelpRetrofitService> getServiceClass() {
        return HelpRetrofitService.class;
    }

    protected HelpRetrofitService getService() {
        return helpRetrofitService;
    }
}