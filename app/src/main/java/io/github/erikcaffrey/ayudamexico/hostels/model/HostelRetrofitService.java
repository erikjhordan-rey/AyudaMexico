package io.github.erikcaffrey.ayudamexico.hostels.model;

import io.reactivex.Observable;
import java.util.List;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface HostelRetrofitService {
    @GET
    Observable<List<Hostel>> getHostelList(@Url String url);
}
