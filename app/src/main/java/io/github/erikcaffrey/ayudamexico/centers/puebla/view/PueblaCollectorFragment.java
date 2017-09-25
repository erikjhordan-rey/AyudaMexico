package io.github.erikcaffrey.ayudamexico.centers.puebla.view;

import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import butterknife.BindView;
import io.github.erikcaffrey.ayudamexico.R;
import io.github.erikcaffrey.ayudamexico.centers.puebla.model.CollectorCenter;
import io.github.erikcaffrey.ayudamexico.centers.puebla.presenter.PueblaCollectorPresenter;
import io.github.erikcaffrey.ayudamexico.common.CoreFragment;
import java.util.List;

public class PueblaCollectorFragment extends CoreFragment implements PueblaCollectorView {

    private PueblaCollectorPresenter presenter;

    @BindView(R.id.collector_recycler_view) RecyclerView rvCollector;
    private PueblaCollectorAdapter collectorAdapter;
    @BindView(R.id.collector_swipe_refresh) SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.collector_progress) ProgressBar progress_center;

    public static PueblaCollectorFragment newInstance() {
        return new PueblaCollectorFragment();
    }

    @Override protected int getLayoutResId() {
        return R.layout.centers_puebla_fragment;
    }

    @Override protected void initPresenter() {
        super.initPresenter();
        presenter = new PueblaCollectorPresenter(this);
    }

    @Override protected void initFragment(@NonNull View view) {
        super.initFragment(view);
        initRecyclerView();
        loadData();
        initSwipe();
    }

    @Override public void showCollectorCenters(List<CollectorCenter> collectorCenters) {
        collectorAdapter.setCenterList(collectorCenters);
        collectorAdapter.notifyDataSetChanged();
    }

    @Override public void showEmptyMessage() {
        Toast.makeText(getContext(), "No se ha encontrado información", Toast.LENGTH_LONG).show();
    }

    @Override public void showErrorMessage() {
        Toast.makeText(getContext(), "Ha Ocurrido un error", Toast.LENGTH_LONG).show();
    }

    @Override public void hideLoading() {
        progress_center.setVisibility(View.GONE);
    }

    @Override public void showLoading() {
        progress_center.setVisibility(View.VISIBLE);
    }

    private void initRecyclerView() {
        rvCollector.setLayoutManager(new LinearLayoutManager(this.getContext()));
        collectorAdapter = new PueblaCollectorAdapter();
        rvCollector.setAdapter(collectorAdapter);
    }

    private void loadData() {
        presenter.loadCollectorCenter();
    }

    private void initSwipe() {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override public void onRefresh() {
                loadData();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }
}
