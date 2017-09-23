package io.github.erikcaffrey.ayudamexico.donations.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import io.github.erikcaffrey.ayudamexico.R;
import io.github.erikcaffrey.ayudamexico.donations.DonationsFragment;
import io.github.erikcaffrey.ayudamexico.donations.service.Donation;

/**
 * Created by armando on 9/22/17.
 */

public class DonationViewHolder extends RecyclerView.ViewHolder {

    TextView txtTitle, txtDescription;
    Button btnUrl;

    public DonationViewHolder(View itemView) {
        super(itemView);
        txtTitle = itemView.findViewById(R.id.donations_title);
        txtDescription = itemView.findViewById(R.id.donations_description);
        btnUrl = itemView.findViewById(R.id.donations_url);
    }

    public void bind(final Donation donation, final DonationsFragment.onClick onClickListener) {
        txtTitle.setText(donation.getTitle());

        if (donation.getDescription() != null) {
            txtDescription.setText(donation.getDescription());
        } else {
            txtDescription.setVisibility(View.GONE);
        }

        btnUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickListener.openLink(donation.getUrl());
            }
        });
    }
}
