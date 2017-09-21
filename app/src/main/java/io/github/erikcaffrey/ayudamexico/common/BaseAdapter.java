package io.github.erikcaffrey.ayudamexico.common;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseAdapter<MODEL> extends RecyclerView.Adapter<BaseViewHolder<MODEL>>{

    private int viewResId;
    private ArrayList<MODEL> items;

    public BaseAdapter(int viewResId) {
        this.viewResId = viewResId;
        this.items = new ArrayList<>();
    }

    @Override
    public BaseViewHolder<MODEL> onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewResId, parent, false);
        return getViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder<MODEL> holder, int position) {
        MODEL item  = items.get(position);
        holder.bindItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(List<MODEL> items) {
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    public abstract BaseViewHolder<MODEL> getViewHolder(View view);
}
