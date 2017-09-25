package io.github.erikcaffrey.ayudamexico.centers.gathering.model;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface CenterRetrofitService {
    @GET
    Observable<List<Center>> getCentersList(@Url String url);
}
