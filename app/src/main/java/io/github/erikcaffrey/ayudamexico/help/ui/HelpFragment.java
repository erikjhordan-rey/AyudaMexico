package io.github.erikcaffrey.ayudamexico.help.ui;

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
import io.github.erikcaffrey.ayudamexico.help.model.Help;
import io.github.erikcaffrey.ayudamexico.help.model.HelpClient;
import io.github.erikcaffrey.ayudamexico.help.model.HelpInteractor;
import io.github.erikcaffrey.ayudamexico.help.presenter.HelpPresenter;
import io.github.erikcaffrey.ayudamexico.help.ui.adapter.HelpAdapter;

public class HelpFragment extends CoreFragment implements HelpPresenter.Ui {

    @BindView(R.id.recycler_help) RecyclerView recycler_help;
    @BindView(R.id.activity_main_swipe_refresh_layout) SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.progress_help) ProgressBar progress_help;

    public static HelpFragment newInstance() {
        return new HelpFragment();
    }

    private HelpAdapter adapter;
    private HelpPresenter helpPresenter;

    @Override protected int getLayoutResId() {
        return R.layout.help_fragment;
    }

    @Override protected void initPresenter() {
        super.initPresenter();
        HelpClient helpClient = new HelpClient();
        HelpInteractor helpInteractor = new HelpInteractor(helpClient);
        helpPresenter = new HelpPresenter(helpInteractor);
        helpPresenter.setUi(this);
    }

    @Override protected void initFragment(@NonNull View view) {
        super.initFragment(view);
        initializeAdapter();
        initializeRecyclerView();
        initSwipe();
        loadData();
    }

    public void loadData() {
        helpPresenter.loadHelpList();
    }

    private void initializeAdapter() {
        adapter = new HelpAdapter(helpPresenter);
    }

    private void initializeRecyclerView() {
        GridLayoutManager lLayout = new GridLayoutManager(getActivity(), 1);
        recycler_help.setLayoutManager(lLayout);
        recycler_help.setAdapter(adapter);
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

    @Override public void showHelpList(List<Help> helpList) {
        adapter.setHelpList(helpList);
    }

    @Override public void showEmptyMessage() {
        Toast.makeText(getContext(), "No se ha encontrado información", Toast.LENGTH_LONG).show();
    }

    @Override public void showErrorMessage() {
        Toast.makeText(getContext(), "Ha Ocurrido un error", Toast.LENGTH_LONG).show();
    }

    @Override public void showDetails(Help help)
    {
        if(help.getLinkMaps() != null && !help.getLinkMaps().isEmpty())
        {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(help.getLinkMaps()));
            startActivity(i);
        }
        else
        {
            showEmptyMessage();
        }
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
