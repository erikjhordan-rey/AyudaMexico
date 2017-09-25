package io.github.erikcaffrey.ayudamexico.centers.rescatemx.ui;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import butterknife.BindView;
import io.github.erikcaffrey.ayudamexico.R;
import io.github.erikcaffrey.ayudamexico.centers.rescatemx.model.Record;
import io.github.erikcaffrey.ayudamexico.centers.rescatemx.presenter.RescateMXPresenter;
import io.github.erikcaffrey.ayudamexico.centers.rescatemx.service.RescateMXClient;
import io.github.erikcaffrey.ayudamexico.centers.rescatemx.service.RescateMXInteractor;
import io.github.erikcaffrey.ayudamexico.centers.rescatemx.ui.adapter.RescateMXAdapter;
import io.github.erikcaffrey.ayudamexico.common.CoreFragment;
import java.util.List;

public class RescateMXFragment extends CoreFragment implements RescateMXPresenter.Ui {

    @BindView(R.id.recycler_center) RecyclerView recycler_center;
    @BindView(R.id.activity_main_swipe_refresh_layout) SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.progress_center) ProgressBar progress_center;

    public static RescateMXFragment newInstance() {
        return new RescateMXFragment();
    }

    private RescateMXAdapter adapter;
    private RescateMXPresenter rescatePresenter;

    @Override protected int getLayoutResId() {
        return R.layout.rescatemx_fragment;
    }

    @Override protected void initPresenter() {
        super.initPresenter();
        RescateMXClient rescateMXClient = new RescateMXClient();
        RescateMXInteractor helpInteractor = new RescateMXInteractor(rescateMXClient);
        rescatePresenter = new RescateMXPresenter(helpInteractor);
        rescatePresenter.setUi(this);
    }

    @Override protected void initFragment(@NonNull View view) {
        super.initFragment(view);
        initializeAdapter();
        initializeRecyclerView();
        initSwipe();
        loadData();
    }

    @Override public void showRescateMXList(List<Record> helpList) {
        adapter.setRecordList(helpList);
    }

    @Override public void showEmptyMessage() {
        Toast.makeText(getContext(), "No se ha encontrado información", Toast.LENGTH_LONG).show();
    }

    @Override public void showErrorMessage() {
        Toast.makeText(getContext(), "Ha Ocurrido un error", Toast.LENGTH_LONG).show();
    }

    @Override public void showDetails(Record record) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(record.getFields().getLinkGoogleMaps()));
        startActivity(i);
    }

    @Override public void hideLoading() {
        progress_center.setVisibility(View.GONE);
    }

    @Override public void showLoading() {
        progress_center.setVisibility(View.VISIBLE);
    }

    @Override public void onDestroy() {
        super.onDestroy();
        rescatePresenter.terminate();
    }

    private void initSwipe() {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override public void onRefresh() {
                refreshContent();
            }
        });
    }

    private void refreshContent() {
        loadData();
        swipeRefreshLayout.setRefreshing(false);
    }

    public void loadData() {
        rescatePresenter.loadHospitalList();
    }

    private void initializeAdapter() {
        adapter = new RescateMXAdapter(rescatePresenter);
    }

    private void initializeRecyclerView() {
        GridLayoutManager lLayout = new GridLayoutManager(getActivity(), 1);
        recycler_center.setLayoutManager(lLayout);
        recycler_center.setAdapter(adapter);
    }
}