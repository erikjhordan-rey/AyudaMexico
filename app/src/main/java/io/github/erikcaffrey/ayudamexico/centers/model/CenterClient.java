package io.github.erikcaffrey.ayudamexico.centers.model;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class CenterClient extends CenterRetrofitClient implements CenterService {

    @Override public Observable<List<Center>> getCentersList() {
        return getService().getCentersList(HELP_URL).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
