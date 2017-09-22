package io.github.erikcaffrey.ayudamexico.hospitals.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import io.github.erikcaffrey.ayudamexico.R;
import io.github.erikcaffrey.ayudamexico.hospitals.model.Hospital;
import io.github.erikcaffrey.ayudamexico.hospitals.presenter.HospitalPresenter;
import java.util.ArrayList;
import java.util.List;

public class HospitalAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Hospital> hospitalList;
    private HospitalPresenter presenter;

    public HospitalAdapter(HospitalPresenter presenter) {
        this.presenter = presenter;
        this.hospitalList = new ArrayList<>();
    }

    @Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hospital_card, parent, false);
        return new HospitalHolder(view, presenter);
    }

    @Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        HospitalHolder hospitalHolder = (HospitalHolder) holder;
        hospitalHolder.render(hospitalList.get(position));
    }

    @Override public int getItemCount() {
        return hospitalList.size();
    }

    public void setHospitalList(List<Hospital> hospitalList) {
        this.hospitalList = hospitalList;
        notifyDataSetChanged();
    }
}
