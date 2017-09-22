package io.github.erikcaffrey.ayudamexico.hostels.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.erikcaffrey.ayudamexico.R;
import io.github.erikcaffrey.ayudamexico.hostels.model.Hostel;
import io.github.erikcaffrey.ayudamexico.hostels.presenter.HostelPresenter;

/**
 * Created by hackro on 21/09/17.
 */

public class HostelsHolder extends RecyclerView.ViewHolder  {

    private HostelPresenter presenter;

    @BindView(R.id.label_name)
    TextView label_name;

    @BindView(R.id.label_asking)
    TextView label_asking;

    @BindView(R.id.label_recive)
    TextView label_recive;

    @BindView(R.id.label_address)
    TextView label_address;


    @BindView(R.id.label_zone)
    TextView label_zone;

    @BindView(R.id.label_update)
    TextView label_update;

    @BindView(R.id.button_map)
    Button button_map;

    public HostelsHolder(View itemView, HostelPresenter presenter) {
        super(itemView);
        this.presenter = presenter;
        ButterKnife.bind(this,itemView);
    }

    private void onItemClick(final Hostel hospital) {
        button_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onItemClick(hospital);
            }
        });
    }

        public void render(Hostel hostel) {
            onItemClick(hostel);

            label_name.setText(hostel.getPlace());
            label_asking.setText(hostel.getNeedsTo());
            label_recive.setText(hostel.getReceive());
            label_address.setText(hostel.getAddress());
            label_zone.setText(hostel.getZone());
            label_update.setText(hostel.getUpdate());

    }


}
