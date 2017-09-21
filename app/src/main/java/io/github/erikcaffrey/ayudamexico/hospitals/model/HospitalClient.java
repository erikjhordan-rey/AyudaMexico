package io.github.erikcaffrey.ayudamexico.hospitals.model;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class HospitalClient extends HospitalRetrofitClient implements HospitalService {

    @Override public Observable<List<Hospital>> getHospitalList() {
        return getService().getHospitalList(HELP_URL).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
