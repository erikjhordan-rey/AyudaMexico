package io.github.erikcaffrey.ayudamexico.centers.rescatemx.service;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

abstract class RescateMXRetrofitClient {

    private final static String URL = "https://cdmx.opendatasoft.com/api/";
    final static String HELP_URL = "https://cdmx.opendatasoft.com/api/records/1.0/search/?dataset=mapeocolaborativobitlyrescatemx-centrosdeacopio-colaborativo&facet=tipo&facet=delegacion_o_municipio&facet=ciudad&facet=entidad";
    private RescateMXRetrofitService rescateMXRetrofitService;

    RescateMXRetrofitClient() {
        initRetrofit();
    }

    private void initRetrofit() {
        Retrofit retrofit = retrofitBuilder();
        rescateMXRetrofitService = retrofit.create(getServiceClass());
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

    private Class<RescateMXRetrofitService> getServiceClass() {
        return RescateMXRetrofitService.class;
    }

    protected RescateMXRetrofitService getService() {
        return rescateMXRetrofitService;
    }
}