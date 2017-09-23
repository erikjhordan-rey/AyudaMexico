package io.github.erikcaffrey.ayudamexico.announcement.model;

import java.util.List;

import io.github.erikcaffrey.ayudamexico.common.BaseRetrofitClient;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by silmood on 9/22/17.
 */

public class AnnouncementClient extends BaseRetrofitClient<AnnouncementRetrofitService> implements AnnouncementService{

    @Override
    public Observable<List<Announcement>> getAnnouncements() {
        return this.service.getAnnouncements().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
