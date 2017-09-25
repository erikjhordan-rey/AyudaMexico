package io.github.erikcaffrey.ayudamexico.common;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class BaseRetrofitClient<T> {

    public T service;

    private final static String URL = "https://script.google.com/";
    private String customUrl;

    public BaseRetrofitClient() {
        initRetrofit();
    }

    public BaseRetrofitClient(String baseUrl) {
        customUrl = baseUrl;
        initRetrofit();
    }

    private void initRetrofit() {
        Retrofit retrofit = retrofitBuilder();
        service = retrofit.create(getGenericApiClass());
    }

    private Retrofit retrofitBuilder() {
        return new Retrofit.Builder().baseUrl(customUrl == null? URL : customUrl)
            .addConverterFactory(GsonConverterFactory.create(getGsonConfig()))
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

    protected Gson getGsonConfig(){
        return new Gson();
    }

    @SuppressWarnings("unchecked") private Class<T> getGenericApiClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
}