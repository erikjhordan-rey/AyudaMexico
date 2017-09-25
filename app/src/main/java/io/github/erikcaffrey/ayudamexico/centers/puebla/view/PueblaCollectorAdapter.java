package io.github.erikcaffrey.ayudamexico.centers.puebla.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import io.github.erikcaffrey.ayudamexico.R;
import io.github.erikcaffrey.ayudamexico.centers.puebla.model.CollectorCenter;

/**
 * Created by Armando on 24/9/2017.
 */

public class PueblaCollectorAdapter extends RecyclerView.Adapter<PueblaCollectorViewHolder>{

    private List<CollectorCenter> centerList = new ArrayList<>();

    @Override
    public PueblaCollectorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.centers_item, parent, false);
        return new PueblaCollectorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PueblaCollectorViewHolder holder, int position) {
        holder.bind(centerList.get(position));
    }

    @Override
    public int getItemCount() {
        return centerList.size();
    }

    public void setCenterList(List<CollectorCenter> centerList) {
        this.centerList = centerList;
    }
}
