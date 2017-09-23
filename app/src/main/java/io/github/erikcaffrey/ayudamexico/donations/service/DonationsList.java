package io.github.erikcaffrey.ayudamexico.donations.service;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by armando on 9/22/17.
 */

public class DonationsList {

    @SerializedName("donations")
    @Expose
    private List<Donation> donations = new ArrayList<>();

    public List<Donation> getDonations() {
        return donations;
    }

    public void setDonations(List<Donation> donations) {
        this.donations = donations;
    }
}
