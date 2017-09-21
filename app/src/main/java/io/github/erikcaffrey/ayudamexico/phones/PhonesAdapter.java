package io.github.erikcaffrey.ayudamexico.phones;


import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.github.erikcaffrey.ayudamexico.R;
import io.github.erikcaffrey.ayudamexico.common.BaseAdapter;
import io.github.erikcaffrey.ayudamexico.common.BaseViewHolder;

public class PhonesAdapter extends BaseAdapter<Phone>{

    public PhonesAdapter() {
        super(R.layout.item_phone);
    }

    @Override
    public BaseViewHolder<Phone> getViewHolder(View view) {
        return new PhoneViewHolder(view);
    }

    public class PhoneViewHolder extends BaseViewHolder<Phone>{

        @BindView(R.id.label_name)
        TextView name;

        @BindView(R.id.label_number)
        TextView number;

        Phone item;

        public PhoneViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void bindItem(Phone item) {
            this.item = item;
            name.setText(item.getName());
            number.setText(item.getNumber());
        }

        @OnClick(R.id.label_number)
        public void call() {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", item.getNumber(), null));
            this.itemView.getContext().startActivity(intent);
        }
    }
}
