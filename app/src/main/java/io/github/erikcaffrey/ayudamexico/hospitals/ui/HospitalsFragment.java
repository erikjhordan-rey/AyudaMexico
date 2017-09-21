package io.github.erikcaffrey.ayudamexico.hospitals.ui;

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
import io.github.erikcaffrey.ayudamexico.common.CoreFragment;
import io.github.erikcaffrey.ayudamexico.hospitals.model.Hospital;
import io.github.erikcaffrey.ayudamexico.hospitals.model.HospitalClient;
import io.github.erikcaffrey.ayudamexico.hospitals.model.HospitalInteractor;
import io.github.erikcaffrey.ayudamexico.hospitals.presenter.HospitalPresenter;
import io.github.erikcaffrey.ayudamexico.hospitals.ui.adapter.HospitalAdapter;

public class HospitalsFragment extends CoreFragment   implements HospitalPresenter.Ui {

    @BindView(R.id.recycler_hospital)
    RecyclerView recycler_hospital;
    @BindView(R.id.activity_main_swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.progress_help)
    ProgressBar progress_help;

    public static HospitalsFragment newInstance() {
        return new HospitalsFragment();
    }

    private HospitalAdapter adapter;
    private HospitalPresenter helpPresenter;

    @Override protected int getLayoutResId() {
        return R.layout.hospitals_fragment;
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
        HospitalClient helpClient = new HospitalClient();
        HospitalInteractor helpInteractor = new HospitalInteractor(helpClient);
        helpPresenter = new HospitalPresenter(helpInteractor);

    }

    public void loadData(){

        helpPresenter.setUi(this);
        helpPresenter.loadHospitalList();
    }

    private void initializeAdapter() {
        adapter = new HospitalAdapter(helpPresenter);
    }

    private void initializeRecyclerView() {
        GridLayoutManager lLayout = new GridLayoutManager(getActivity(), 1);
        recycler_hospital.setLayoutManager(lLayout);
        recycler_hospital.setAdapter(adapter);
    }

    @Override public void showHospitalList(List<Hospital> helpList) {
        adapter.setHospitalList(helpList);
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
        progress_help.setVisibility(View.GONE);
    }

    @Override public void showLoading() {
        progress_help.setVisibility(View.VISIBLE);
    }

    @Override public void onDestroy() {
        super.onDestroy();
        helpPresenter.terminate();
    }
}