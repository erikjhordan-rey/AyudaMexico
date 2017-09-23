package io.github.erikcaffrey.ayudamexico.donations.view;

import java.util.List;

import io.github.erikcaffrey.ayudamexico.donations.service.Donation;

/**
 * Created by armando on 9/22/17.
 */

public interface DonationsView {
    void showDonations(List<Donation> donationList);
}
