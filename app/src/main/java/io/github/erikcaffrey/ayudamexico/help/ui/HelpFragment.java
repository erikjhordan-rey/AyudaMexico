package io.github.erikcaffrey.ayudamexico.help.ui;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;
import butterknife.BindView;
import io.github.erikcaffrey.ayudamexico.R;
import io.github.erikcaffrey.ayudamexico.common.CoreFragment;
import io.github.erikcaffrey.ayudamexico.help.model.Help;
import io.github.erikcaffrey.ayudamexico.help.model.HelpClient;
import io.github.erikcaffrey.ayudamexico.help.model.HelpInteractor;
import io.github.erikcaffrey.ayudamexico.help.presenter.HelpPresenter;
import io.github.erikcaffrey.ayudamexico.help.ui.adapter.HelpAdapter;
import java.util.List;

public class HelpFragment extends CoreFragment implements HelpPresenter.Ui {

    @BindView(R.id.recycler_help) RecyclerView recycler_help;

    public static HelpFragment newInstance() {
        return new HelpFragment();
    }

    private HelpAdapter adapter;
    private HelpPresenter helpPresenter;

    @Override protected int getLayoutResId() {
        return R.layout.help_fragment;
    }

    @Override protected void initFragment(@NonNull View view) {
        super.initFragment(view);
        initializeAdapter();
        initializeRecyclerView();
    }

    @Override protected void initPresenter() {
        super.initPresenter();
        HelpClient helpClient = new HelpClient();
        HelpInteractor helpInteractor = new HelpInteractor(helpClient);
        helpPresenter = new HelpPresenter(helpInteractor);
        helpPresenter.setUi(this);
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

    @Override public void showHelpList(List<Help> helpList) {
        adapter.setHelpList(helpList);
    }

    @Override public void showEmptyMessage() {
        Toast.makeText(getContext(), "No se ha encontrado información", Toast.LENGTH_LONG).show();
    }

    @Override public void showErrorMessage() {
        Toast.makeText(getContext(), "Ha Ocurrido un error", Toast.LENGTH_LONG).show();
    }

    @Override public void showDetails(Help help) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(help.getLinkMaps()));
        startActivity(i);
    }

    @Override public void hideLoading() {

    }

    @Override public void showLoading() {

    }

    @Override public void onDestroy() {
        super.onDestroy();
        helpPresenter.terminate();
    }
}
