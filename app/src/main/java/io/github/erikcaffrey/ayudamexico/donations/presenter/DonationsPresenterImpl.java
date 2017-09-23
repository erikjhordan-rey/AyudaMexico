package io.github.erikcaffrey.ayudamexico.donations.presenter;

import java.util.List;

import io.github.erikcaffrey.ayudamexico.donations.service.Donation;
import io.github.erikcaffrey.ayudamexico.donations.service.DonationsClient;
import io.github.erikcaffrey.ayudamexico.donations.view.DonationsView;

/**
 * Created by armando on 9/22/17.
 */

public class DonationsPresenterImpl implements DonationsPresenter {
    private final DonationsView view;
    private final DonationsClient client;

    public DonationsPresenterImpl(DonationsView view) {
        this.view = view;
        this.client = new DonationsClient(this);
    }

    public void getDonations(){
        client.getDonationList();
    }

    @Override
    public void processDonationList(List<Donation> donations) {
        view.showDonations(donations);
    }
}
