package io.github.erikcaffrey.ayudamexico.hostels.ui;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
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
import io.github.erikcaffrey.ayudamexico.hostels.model.Hostel;
import io.github.erikcaffrey.ayudamexico.hostels.model.HostelClient;
import io.github.erikcaffrey.ayudamexico.hostels.model.HostelInteractor;
import io.github.erikcaffrey.ayudamexico.hostels.presenter.HostelPresenter;
import io.github.erikcaffrey.ayudamexico.hostels.ui.adapter.HostelsAdapter;

public class HostelsFragment extends CoreFragment implements HostelPresenter.Ui {

    @BindView(R.id.recycler_hostels)  RecyclerView recycler_hostels;
    @BindView(R.id.swipe_refresh_hostels)  SwipeRefreshLayout swipe_refresh_hostels;
    @BindView(R.id.progress_hostels) ProgressBar progress_hostels;
    private HostelsAdapter adapter;

    public static HostelsFragment newInstance() {
        return new HostelsFragment();
    }

    private HostelPresenter hostelPresenter;

    @Override protected int getLayoutResId() {
        return R.layout.hostels_fragment;
    }

    @Override protected void initPresenter() {
        super.initPresenter();
        final HostelClient hostelClient = new HostelClient();
        final HostelInteractor hostelInteractor = new HostelInteractor(hostelClient);
        hostelPresenter = new HostelPresenter(hostelInteractor);
        hostelPresenter.setUi(this);
    }
    private void initSwipe() {
        swipe_refresh_hostels.setColorSchemeColors(getColor(R.color.colorPrimaryDark), getColor(R.color.colorPrimary),
            getColor(R.color.colorAccent));
        swipe_refresh_hostels.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshContent();
            }
        });
    }

    public void loadData(){
        hostelPresenter.loadHostelList();
    }

    private void initializeAdapter() {
        adapter = new HostelsAdapter(hostelPresenter);
    }

    private void initializeRecyclerView() {
        GridLayoutManager lLayout = new GridLayoutManager(getActivity(), 1);
        recycler_hostels.setLayoutManager(lLayout);
        recycler_hostels.setAdapter(adapter);
    }



    private void refreshContent() {
        loadData();
        swipe_refresh_hostels.setRefreshing(false);
    }


    @Override protected void initFragment(@NonNull View view) {
        super.initFragment(view);
        initializeAdapter();
        initializeRecyclerView();
        initSwipe();
        loadData();
    }

    @Override public void showHostelList(List<Hostel> hostelList) {
        adapter.setHostelList(hostelList);
    }

    @Override public void showEmptyMessage() {
        Toast.makeText(getContext(), "No se ha encontrado información", Toast.LENGTH_LONG).show();
    }

    @Override public void showErrorMessage() {
        Toast.makeText(getContext(), "Ha Ocurrido un error", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showMap(Hostel hostel) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(hostel.getMap()));
        startActivity(i);
    }


    @Override public void hideLoading() {
        progress_hostels.setVisibility(View.GONE);
    }

    @Override public void showLoading() {
        progress_hostels.setVisibility(View.VISIBLE);
    }

    private int getColor(int color) {
        return ContextCompat.getColor(getActivity(), color);
    }
}
