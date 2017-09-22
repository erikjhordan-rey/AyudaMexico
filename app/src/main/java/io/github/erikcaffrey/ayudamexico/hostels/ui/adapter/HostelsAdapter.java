package io.github.erikcaffrey.ayudamexico.hostels.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import io.github.erikcaffrey.ayudamexico.R;
import io.github.erikcaffrey.ayudamexico.hostels.model.Hostel;
import io.github.erikcaffrey.ayudamexico.hostels.presenter.HostelPresenter;

/**
 * Created by hackro on 21/09/17.
 */

public class HostelsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    private List<Hostel> hospitalList;
    private HostelPresenter presenter;

    public HostelsAdapter(HostelPresenter presenter) {
        this.presenter = presenter;
        this.hospitalList = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hostel_card,parent,false);
        return new HostelsHolder(view, presenter);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        HostelsHolder hostelsHolder = (HostelsHolder) holder;
        hostelsHolder.render(hospitalList.get(position));
    }

    @Override
    public int getItemCount() {
        return hospitalList.size();
    }

    public void setHostelList(List<Hostel> hospitalList) {
        this.hospitalList = hospitalList;
        notifyDataSetChanged();
    }
}
