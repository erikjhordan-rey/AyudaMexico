package io.github.erikcaffrey.ayudamexico.common;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class BaseViewHolder<MODEL> extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindItem(MODEL item);
}
