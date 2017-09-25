package io.github.erikcaffrey.ayudamexico.centers.rescatemx.service;

import io.github.erikcaffrey.ayudamexico.centers.rescatemx.model.RescateMX;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface RescateMXRetrofitService {
    @GET
    Observable<RescateMX> getCenterList(@Url String url);
}
