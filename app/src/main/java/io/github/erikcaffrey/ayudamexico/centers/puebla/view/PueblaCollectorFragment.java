package io.github.erikcaffrey.ayudamexico.centers.puebla.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import butterknife.BindView;
import io.github.erikcaffrey.ayudamexico.R;
import io.github.erikcaffrey.ayudamexico.centers.puebla.model.CollectorCenter;
import io.github.erikcaffrey.ayudamexico.centers.puebla.presenter.PueblaCollectorPresenter;
import io.github.erikcaffrey.ayudamexico.common.CoreFragment;

/**
 * Created by Armando on 24/9/2017.
 */

public class PueblaCollectorFragment extends CoreFragment implements PueblaCollectorView {

    private PueblaCollectorPresenter presenter;

    @BindView(R.id.collector_recycler_view)
    RecyclerView rvCollector;
    private PueblaCollectorAdapter collectorAdapter;

    public static PueblaCollectorFragment newInstance(){return new PueblaCollectorFragment();}

    @Override
    protected int getLayoutResId() {
        return R.layout.centers_puebla_fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initRecyclerView();
        presenter = new PueblaCollectorPresenter(this);
        presenter.loadCollectorCenter();

    }

    private void initRecyclerView() {
        rvCollector.setLayoutManager(new LinearLayoutManager(this.getContext()));
        collectorAdapter = new PueblaCollectorAdapter();
        rvCollector.setAdapter(collectorAdapter);
    }

    @Override
    public void showCollectorCenters(List<CollectorCenter> collectorCenters) {
        collectorAdapter.setCenterList(collectorCenters);
        collectorAdapter.notifyDataSetChanged();
    }
}
