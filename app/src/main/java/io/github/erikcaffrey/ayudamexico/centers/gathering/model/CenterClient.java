package io.github.erikcaffrey.ayudamexico.centers.gathering.model;

import io.github.erikcaffrey.ayudamexico.common.BaseRetrofitClient;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

import static io.github.erikcaffrey.ayudamexico.common.Constans.CENTERS_URL;

public class CenterClient extends BaseRetrofitClient<CenterRetrofitService> implements CenterService {

    @Override public Observable<List<Center>> getCentersList() {
        return service.getCentersList(CENTERS_URL).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
