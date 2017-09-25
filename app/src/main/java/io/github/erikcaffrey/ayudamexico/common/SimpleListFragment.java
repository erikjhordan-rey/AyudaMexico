package io.github.erikcaffrey.ayudamexico.common;

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
import io.github.erikcaffrey.ayudamexico.help.model.Help;
import io.github.erikcaffrey.ayudamexico.help.model.HelpClient;
import io.github.erikcaffrey.ayudamexico.help.model.HelpInteractor;
import io.github.erikcaffrey.ayudamexico.help.presenter.HelpPresenter;
import io.github.erikcaffrey.ayudamexico.help.ui.HelpFragment;
import io.github.erikcaffrey.ayudamexico.help.ui.adapter.HelpAdapter;

/**
 * Created by silmood on 9/22/17.
 */

public abstract class SimpleListFragment<MODEL> extends CoreFragment implements SimpleListUi<MODEL>{

    @BindView(R.id.recycler)
    RecyclerView recycler;

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    @BindView(R.id.progress)
    ProgressBar progress;

    private BaseAdapter<MODEL> adapter;
    private ListPresenter listPresenter;

    @Override protected int getLayoutResId() {
        return R.layout.list_fragment;
    }

    public abstract ListPresenter getListPresenter();
    public abstract BaseAdapter<MODEL> getAdapter();

    @Override protected void initPresenter() {
        super.initPresenter();
        listPresenter = getListPresenter();
        listPresenter.setUi(this);
    }

    @Override protected void initFragment(@NonNull View view) {
        super.initFragment(view);
        initializeAdapter();
        initializeRecyclerView();
        initSwipe();
        loadData();
    }

    public void loadData() {
        listPresenter.loadList();
    }

    private void initializeAdapter() {
        adapter = getAdapter();
    }

    private void initializeRecyclerView() {
        GridLayoutManager lLayout = new GridLayoutManager(getActivity(), 1);
        recycler.setLayoutManager(lLayout);
        recycler.setAdapter(adapter);
    }

    private void initSwipe() {
        swipeRefreshLayout.setColorSchemeColors(getColor(R.color.colorPrimaryDark), getColor(R.color.colorPrimary),
            getColor(R.color.colorAccent));
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

    @Override
    public void showList(List<MODEL> list) {
        adapter.setItems(list);
    }

    @Override public void showEmptyMessage() {
        Toast.makeText(getContext(), "No se ha encontrado información", Toast.LENGTH_LONG).show();
    }

    @Override public void showErrorMessage() {
        Toast.makeText(getContext(), "Ha Ocurrido un error", Toast.LENGTH_LONG).show();
    }

    @Override public void hideLoading() {
        progress.setVisibility(View.GONE);
    }

    @Override public void showLoading() {
        progress.setVisibility(View.VISIBLE);
    }

    @Override public void onDestroy() {
        super.onDestroy();
        listPresenter.terminate();
    }

    private int getColor(int color) {
        return ContextCompat.getColor(getActivity(), color);
    }
}
