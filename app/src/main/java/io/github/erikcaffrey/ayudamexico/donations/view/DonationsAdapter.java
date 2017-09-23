package io.github.erikcaffrey.ayudamexico.donations.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import io.github.erikcaffrey.ayudamexico.R;
import io.github.erikcaffrey.ayudamexico.donations.DonationsFragment;
import io.github.erikcaffrey.ayudamexico.donations.service.Donation;

/**
 * Created by armando on 9/22/17.
 */

public class DonationsAdapter extends RecyclerView.Adapter<DonationViewHolder> {
    private final DonationsFragment.onClick onClickListener;
    private List<Donation> donationList = new ArrayList<>();

    public DonationsAdapter(DonationsFragment.onClick onClick) {
        this.onClickListener = onClick;
    }

    public void setDonationList(List<Donation> donationList) {
        this.donationList = donationList;
    }

    @Override
    public DonationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.donations_items, parent, false);
        return new DonationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DonationViewHolder holder, int position) {
        holder.bind(donationList.get(position), onClickListener);
    }

    @Override
    public int getItemCount() {
        return donationList.size();
    }
}
