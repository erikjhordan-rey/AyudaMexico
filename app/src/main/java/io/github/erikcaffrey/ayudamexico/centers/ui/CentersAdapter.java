package io.github.erikcaffrey.ayudamexico.centers.ui;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.github.erikcaffrey.ayudamexico.R;
import io.github.erikcaffrey.ayudamexico.centers.model.Center;
import io.github.erikcaffrey.ayudamexico.common.BaseAdapter;
import io.github.erikcaffrey.ayudamexico.common.BaseViewHolder;


public class CentersAdapter extends BaseAdapter<Center>{

    public CentersAdapter() {
        super(R.layout.item_center);
    }

    @Override
    public BaseViewHolder<Center> getViewHolder(View view) {
        return new CenterHolder(view);
    }

    class CenterHolder extends BaseViewHolder<Center> {

        @BindView(R.id.label_name)
        TextView name;

        @BindView(R.id.label_address)
        TextView address;

        @BindView(R.id.label_asking)
        TextView asking;

        @BindView(R.id.label_update)
        TextView update;

        @BindView(R.id.label_zone)
        TextView zone;

        @BindView(R.id.button_map)
        Button map;

        @BindView(R.id.button_info)
        Button info;

        private Center item;

        public CenterHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void bindItem(Center item) {
            this.item = item;

            name.setText(item.getPlace());
            address.setText(item.getAddress());
            asking.setText(item.getAsking());
            update.setText(item.getUpdated());
            zone.setText(item.getZone());
        }

        @OnClick(R.id.button_map)
        public void showMap() {
            if(item.getMap().isEmpty()) {
                showEmptyMessage();
            } else {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(item.getMap()));
                if(i.resolveActivity(itemView.getContext().getPackageManager()) != null) {
                    itemView.getContext().startActivity(i);
                }
            }
        }

        @OnClick(R.id.button_info)
        public void showInfo() {
            if(item.getInfo().isEmpty()) {
                showEmptyMessage();
            } else {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(item.getInfo()));
                if(i.resolveActivity(itemView.getContext().getPackageManager()) != null) {
                    itemView.getContext().startActivity(i);
                }
            }
        }

        private void showEmptyMessage() {
            Toast.makeText(itemView.getContext(), R.string.no_data, Toast.LENGTH_SHORT).show();
        }
    }
}
