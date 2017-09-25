package io.github.erikcaffrey.ayudamexico.support.model;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by silmood on 9/24/17.
 */

public interface SupportRetrofitService {

    @GET("search/?dataset=apoyomorelos&rows=50")
    Observable<List<SupportSpot>> getSupportSpots();
}
