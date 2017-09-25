package io.github.erikcaffrey.ayudamexico.centers.rescatemx.service;

import io.github.erikcaffrey.ayudamexico.centers.rescatemx.model.RescateMX;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RescateMXClient extends RescateMXRetrofitClient implements RescateMXService {

    @Override public Observable<RescateMX> getCenterList() {
        return getService().getCenterList(HELP_URL).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
