package io.github.erikcaffrey.ayudamexico.support.ui;

import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.erikcaffrey.ayudamexico.R;
import io.github.erikcaffrey.ayudamexico.common.BaseAdapter;
import io.github.erikcaffrey.ayudamexico.common.BaseViewHolder;
import io.github.erikcaffrey.ayudamexico.support.model.SupportSpot;

/**
 * Created by silmood on 9/24/17.
 */

public class SupportSpotAdapter extends BaseAdapter<SupportSpot>{

    public SupportSpotAdapter() {
        super(R.layout.item_support_spot);
    }

    @Override
    public BaseViewHolder<SupportSpot> getViewHolder(View view) {
        return new SupportSpotViewHolder(view) ;
    }

    class SupportSpotViewHolder extends BaseViewHolder<SupportSpot> {

        @BindView(R.id.label_category)
        TextView category;

        @BindView(R.id.label_offering)
        TextView offering;

        @BindView(R.id.label_contact)
        TextView contact;

        @BindView(R.id.label_name)
        TextView name;

        public SupportSpotViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void bindItem(SupportSpot item) {
            category.setText(item.getCategory());
            offering.setText(item.getOffering());
            contact.setText(item.getContact());
            name.setText(item.getName());
        }
    }
}
