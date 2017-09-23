package io.github.erikcaffrey.ayudamexico.donations.service;

import java.util.List;

import io.github.erikcaffrey.ayudamexico.donations.presenter.DonationsPresenter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by armando on 9/22/17.
 */

public class DonationsClient extends DonationRetrofitClient implements DonationsService {

    private final DonationsPresenter presenter;

    public DonationsClient(DonationsPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getDonationList() {
        Call<DonationsList> donationListCall = DonationRetrofitClient.getApiService().getDonationList();
        donationListCall.enqueue(new Callback<DonationsList>() {
            @Override
            public void onResponse(Call<DonationsList> call, Response<DonationsList> response) {
                if(response.isSuccessful()){
                    List<Donation> donations = response.body().getDonations();
                    presenter.processDonationList(donations);
                }

            }

            @Override
            public void onFailure(Call call, Throwable t) {

            }
        });
    }
}
