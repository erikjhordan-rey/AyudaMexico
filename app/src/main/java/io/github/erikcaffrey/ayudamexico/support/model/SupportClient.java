package io.github.erikcaffrey.ayudamexico.support.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import io.github.erikcaffrey.ayudamexico.common.BaseRetrofitClient;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by silmood on 9/24/17.
 */

public class SupportClient extends BaseRetrofitClient<SupportRetrofitService> implements SupportService {

    private static final String URL = "https://cdmx.opendatasoft.com/api/records/1.0/";

    public SupportClient() {
        super(URL);
    }

    @Override
    protected Gson getGsonConfig() {
        Type type = new TypeToken<List<SupportSpot>>() { }.getType();

        return new GsonBuilder()
                .registerTypeAdapter(type, new SupportSpotDeserializer())
                .create();
    }

    @Override
    public Observable<List<SupportSpot>> getSupportSpots() {
        return this.service.getSupportSpots().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
