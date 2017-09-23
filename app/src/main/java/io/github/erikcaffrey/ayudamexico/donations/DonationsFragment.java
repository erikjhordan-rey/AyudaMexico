package io.github.erikcaffrey.ayudamexico.donations;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import butterknife.BindView;
import io.github.erikcaffrey.ayudamexico.R;
import io.github.erikcaffrey.ayudamexico.common.CoreFragment;
import io.github.erikcaffrey.ayudamexico.donations.presenter.DonationsPresenterImpl;
import io.github.erikcaffrey.ayudamexico.donations.service.Donation;
import io.github.erikcaffrey.ayudamexico.donations.view.DonationsAdapter;
import io.github.erikcaffrey.ayudamexico.donations.view.DonationsView;

public class DonationsFragment extends CoreFragment implements DonationsView {

    @BindView(R.id.recycler_view_donations)
    RecyclerView donationsRecyclerView;

    private DonationsPresenterImpl presenter;
    private DonationsAdapter donationsAdapter;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new DonationsPresenterImpl(this);
        presenter.getDonations();

        donationsRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        donationsAdapter = new DonationsAdapter(new DonationsFragment.onClick(){

            @Override
            public void openLink(String url) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        donationsRecyclerView.setAdapter(donationsAdapter);

    }

    public static DonationsFragment newInstance() {
        return new DonationsFragment();
    }

    @Override protected int getLayoutResId() {
        return R.layout.donations_fragment;
    }


    @Override
    public void showDonations(List<Donation> donationList) {
        donationsAdapter.setDonationList(donationList);
        donationsAdapter.notifyDataSetChanged();
    }

    public interface onClick {
        void openLink(String url);
    }
}
