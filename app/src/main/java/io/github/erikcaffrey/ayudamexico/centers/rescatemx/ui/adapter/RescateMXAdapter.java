package io.github.erikcaffrey.ayudamexico.centers.rescatemx.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import io.github.erikcaffrey.ayudamexico.R;
import io.github.erikcaffrey.ayudamexico.centers.rescatemx.model.Record;
import io.github.erikcaffrey.ayudamexico.centers.rescatemx.presenter.RescateMXPresenter;

public class RescateMXAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Record> recordList;
    private RescateMXPresenter presenter;

    public RescateMXAdapter(RescateMXPresenter presenter) {
        this.presenter = presenter;
        this.recordList = new ArrayList<>();
    }

    @Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.centers_item, parent, false);
        return new RescateMXHolder(view, presenter);
    }

    @Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        RescateMXHolder rescateMXHolder = (RescateMXHolder) holder;
        rescateMXHolder.render(recordList.get(position));
    }

    @Override public int getItemCount() {
        return recordList.size();
    }

    public void setRecordList(List<Record> recordList) {
        this.recordList = recordList;
        notifyDataSetChanged();
    }
}
