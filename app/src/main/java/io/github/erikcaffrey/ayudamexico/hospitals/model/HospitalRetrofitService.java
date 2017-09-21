package io.github.erikcaffrey.ayudamexico.hospitals.model;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface HospitalRetrofitService {
    @GET
    Observable<List<Hospital>> getHospitalList(@Url String url);
}
