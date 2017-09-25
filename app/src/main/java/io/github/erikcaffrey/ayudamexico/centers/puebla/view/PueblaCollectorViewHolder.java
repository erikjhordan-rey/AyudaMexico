package io.github.erikcaffrey.ayudamexico.centers.puebla.view;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import io.github.erikcaffrey.ayudamexico.R;
import io.github.erikcaffrey.ayudamexico.centers.puebla.model.CollectorCenter;

import static android.view.View.GONE;

/**
 * Created by Armando on 24/9/2017.
 */

public class PueblaCollectorViewHolder extends RecyclerView.ViewHolder {

    private static final String INTENT_PREFIX_GEO = "geo:";
    private static final String INTENT_DATA_GEO = "%s,%s?q=%s,%s(%s)";
    private TextView txtCenterName, txtCenterAsking, txtCenterAddress, txtCenterPhone,
            txtCenterLastUpdate;
    private Button btnMap;

    public PueblaCollectorViewHolder(View itemView) {
        super(itemView);
        txtCenterName = itemView.findViewById(R.id.txt_center_name);
        txtCenterAsking = itemView.findViewById(R.id.txt_center_asking);
        txtCenterAddress = itemView.findViewById(R.id.txt_center_address);
        txtCenterPhone = itemView.findViewById(R.id.txt_center_phone);
        txtCenterLastUpdate = itemView.findViewById(R.id.txt_center_last_update);
        btnMap = itemView.findViewById(R.id.btn_map);
    }

    public void bind(final CollectorCenter center) {
        if (center.getName() != null) {
            txtCenterName.setText(center.getName());
        } else {
            txtCenterName.setText("Particular");
        }

        if (center.getAsking() != null) {
            txtCenterAsking.setText(center.getAsking());
        } else {
            txtCenterAsking.setText("Generico");
        }

        if (center.getAddress() != null) {
            txtCenterAddress.setText(center.getAddress());
        } else {
            txtCenterAddress.setVisibility(GONE);
        }

        if (center.getPhone() != null) {
            txtCenterPhone.setText(center.getPhone());
        } else {
            txtCenterPhone.setText("No Precisa");
        }

        if (center.hasCoordinates()) {
            btnMap.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(String.format(INTENT_PREFIX_GEO + INTENT_DATA_GEO,
                            center.getLatitude().toString(), center.getLongitude().toString(),
                            center.getLatitude().toString(), center.getLongitude().toString(),
                            center.getName())));
                    itemView.getContext().startActivity(intent);
                }
            });
        } else {
            btnMap.setVisibility(GONE);
        }
    }
}
