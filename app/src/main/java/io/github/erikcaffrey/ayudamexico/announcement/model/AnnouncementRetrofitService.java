package io.github.erikcaffrey.ayudamexico.announcement.model;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by silmood on 9/22/17.
 */

public interface AnnouncementRetrofitService {

    @GET("macros/s/AKfycbycrDe-S2xW5A4MQGvxvvcAKfuPaWWOGlWYPcKS8f7basGz_mM/exec")
    Observable<List<Announcement>> getAnnouncements();
}
