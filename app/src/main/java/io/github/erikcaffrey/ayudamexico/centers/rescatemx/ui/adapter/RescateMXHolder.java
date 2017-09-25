package io.github.erikcaffrey.ayudamexico.centers.rescatemx.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.erikcaffrey.ayudamexico.R;
import io.github.erikcaffrey.ayudamexico.centers.rescatemx.model.Record;
import io.github.erikcaffrey.ayudamexico.centers.rescatemx.presenter.RescateMXPresenter;

/**
 * Created by hackro on 21/09/17.
 */

public class RescateMXHolder extends RecyclerView.ViewHolder  {

    private RescateMXPresenter presenter;

    @BindView(R.id.txt_center_name) TextView txtCenterName;
    @BindView(R.id.txt_center_asking) TextView txtCenterAsking;
    @BindView(R.id.txt_center_address) TextView txtCenterAddress;
    @BindView(R.id.txt_center_phone) TextView txtCenterPhone;
    @BindView(R.id.txt_center_last_update) TextView txt_center_last_update;
    @BindView(R.id.label_more_info)TextView label_more_info;
    @BindView(R.id.btn_map)Button btn_map;



    public RescateMXHolder(View itemView, RescateMXPresenter presenter) {
        super(itemView);
        this.presenter = presenter;
        ButterKnife.bind(this,itemView);
    }

    private void onItemClick(final Record record) {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onItemClick(record);
            }
        });
        btn_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onItemClick(record);
            }
        });
    }

        public void render(Record record) {


            txtCenterName.setText(record.getFields().getNombreDelCentroDeAcopio());
            if(record.getFields().getNecesidades()!=null && !record.getFields().getNecesidades().isEmpty() && !record.getFields().getNecesidades().equals(""))
                txtCenterAsking.setText(record.getFields().getNecesidades());
            else
                txtCenterAsking.setVisibility(View.GONE);

            txtCenterAddress.setText(record.getFields().getDireccionAgregada());

            if(record.getFields().getTelefono()!=null && !record.getFields().getTelefono().isEmpty() && !record.getFields().getTelefono().equals(""))
                txtCenterPhone.setText(record.getFields().getTelefono());
            else
                txtCenterPhone.setVisibility(View.GONE);

            txt_center_last_update.setText(record.getFields().getUltimaActualizacion());

            label_more_info.setVisibility(View.GONE);

            if (record.getFields().getLinkGoogleMaps()==null)
                btn_map.setVisibility(View.GONE);
            else
                onItemClick(record);

    }


}
