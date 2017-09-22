package io.github.erikcaffrey.ayudamexico.hospitals.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.erikcaffrey.ayudamexico.R;
import io.github.erikcaffrey.ayudamexico.hospitals.model.Hospital;
import io.github.erikcaffrey.ayudamexico.hospitals.presenter.HospitalPresenter;

/**
 * Created by hackro on 21/09/17.
 */

public class HospitalHolder extends RecyclerView.ViewHolder  {

    private HospitalPresenter presenter;

    @BindView(R.id.name_hospital)
    TextView name_hospital;

    @BindView(R.id.help_required)
    TextView help_required;

    @BindView(R.id.help_recive)
    TextView help_recive;

    @BindView(R.id.direction)
    TextView direction;


    @BindView(R.id.zone)
    TextView zone;


    @BindView(R.id.detail)
    TextView detail;

    @BindView(R.id.date_update)
    TextView date_update;


    public HospitalHolder(View itemView, HospitalPresenter presenter) {
        super(itemView);
        this.presenter = presenter;
        ButterKnife.bind(this,itemView);
    }

    private void onItemClick(final Hospital hospital) {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onItemClick(hospital);
            }
        });
    }

        public void render(Hospital hospital) {
            onItemClick(hospital);

            name_hospital.setText(hospital.getHospital());
            help_required.setText(hospital.getNECESITAN());
            help_recive.setText(hospital.getRECIBEN());
            direction.setText(hospital.getDIRECCION());
            zone.setText(hospital.getZONA());
            detail.setText(hospital.getMASINFO());
            date_update.setText(hospital.getACTUALIZACION());

    }


}
