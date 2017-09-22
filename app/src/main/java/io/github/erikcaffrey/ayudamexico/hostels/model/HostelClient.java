package io.github.erikcaffrey.ayudamexico.hostels.model;

import io.github.erikcaffrey.ayudamexico.common.BaseRetrofitClient;
import io.github.erikcaffrey.ayudamexico.common.Constans;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

public class HostelClient extends BaseRetrofitClient<HostelRetrofitService> implements HostelService {

    @Override public Observable<List<Hostel>> getHostelList() {
        return service.getHostelList(Constans.HOSTEL_URL).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
