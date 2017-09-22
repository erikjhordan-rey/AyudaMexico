package io.github.erikcaffrey.ayudamexico.centers.ui;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import io.github.erikcaffrey.ayudamexico.R;
import io.github.erikcaffrey.ayudamexico.centers.model.Center;
import io.github.erikcaffrey.ayudamexico.centers.model.CenterClient;
import io.github.erikcaffrey.ayudamexico.centers.model.CenterInteractor;
import io.github.erikcaffrey.ayudamexico.centers.presenter.GatheringPresenter;
import io.github.erikcaffrey.ayudamexico.common.CoreFragment;
import io.github.erikcaffrey.ayudamexico.hospitals.model.Hospital;
import io.github.erikcaffrey.ayudamexico.hospitals.model.HospitalClient;
import io.github.erikcaffrey.ayudamexico.hospitals.model.HospitalInteractor;
import io.github.erikcaffrey.ayudamexico.hospitals.presenter.HospitalPresenter;
import io.github.erikcaffrey.ayudamexico.hospitals.ui.adapter.HospitalAdapter;

public class GatheringFragment extends CoreFragment implements GatheringPresenter.Ui{

    @BindView(R.id.recycler_center)
    RecyclerView recyclerCenter;

    @BindView(R.id.activity_main_swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    @BindView(R.id.progress_help)
    ProgressBar progressHelp;

    public static GatheringFragment newInstance() {
        return new GatheringFragment();
    }

    private CentersAdapter adapter;
    private GatheringPresenter helpPresenter;

    @Override protected int getLayoutResId() {
        return R.layout.gathering_fragment;
    }

    @Override protected void initFragment(@NonNull View view) {
        super.initFragment(view);
        initializeAdapter();
        initializeRecyclerView();
        initSwipe();
        loadData();
    }

    private void initSwipe() {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshContent();
            }
        });
    }

    private void refreshContent() {
        loadData();
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override protected void initPresenter() {
        super.initPresenter();
        CenterClient helpClient = new CenterClient();
        CenterInteractor helpInteractor = new CenterInteractor(helpClient);
        helpPresenter = new GatheringPresenter(helpInteractor);

    }

    public void loadData(){
        helpPresenter.setUi(this);
        helpPresenter.loadCentersList();
    }

    private void initializeAdapter() {
        adapter = new CentersAdapter();
    }

    private void initializeRecyclerView() {
        GridLayoutManager lLayout = new GridLayoutManager(getActivity(), 1);
        recyclerCenter.setLayoutManager(lLayout);
        recyclerCenter.setAdapter(adapter);
    }

    @Override public void showCentersList(List<Center> helpList) {
        adapter.setItems(helpList);
    }

    @Override public void showEmptyMessage() {
        Toast.makeText(getContext(), "No se ha encontrado información", Toast.LENGTH_LONG).show();
    }

    @Override public void showErrorMessage() {
        Toast.makeText(getContext(), "Ha Ocurrido un error", Toast.LENGTH_LONG).show();
    }

    @Override public void showDetails(Hospital hospital) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(hospital.getMAPA()));
        startActivity(i);
    }

    @Override public void hideLoading() {
        progressHelp.setVisibility(View.GONE);
    }

    @Override public void showLoading() {
        progressHelp.setVisibility(View.VISIBLE);
    }

    @Override public void onDestroy() {
        super.onDestroy();
        helpPresenter.terminate();
    }
}
