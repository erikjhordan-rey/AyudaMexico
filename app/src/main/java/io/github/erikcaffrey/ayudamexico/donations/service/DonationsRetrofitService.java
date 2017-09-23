package io.github.erikcaffrey.ayudamexico.donations.service;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by armando on 9/22/17.
 */

public interface DonationsRetrofitService {
    @GET("donations.json")
    Call<DonationsList> getDonationList();
}
