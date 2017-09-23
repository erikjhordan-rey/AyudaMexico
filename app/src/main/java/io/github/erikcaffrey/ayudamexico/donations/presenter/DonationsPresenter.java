package io.github.erikcaffrey.ayudamexico.donations.presenter;

import java.util.List;

import io.github.erikcaffrey.ayudamexico.donations.service.Donation;

/**
 * Created by armando on 9/22/17.
 */

public interface DonationsPresenter {
    void processDonationList(List<Donation> donations);
}
