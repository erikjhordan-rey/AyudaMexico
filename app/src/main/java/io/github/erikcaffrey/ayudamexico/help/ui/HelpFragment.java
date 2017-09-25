package io.github.erikcaffrey.ayudamexico.help.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ShareCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.OnClick;
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
    @BindView(R.id.activity_main_swipe_refresh_layout) SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.progress_help) ProgressBar progress_help;
    @BindView(R.id.help_results) TextView helpResultsTV;
    @BindView(R.id.help_results_ll) LinearLayout helpResultsLL;

    public static HelpFragment newInstance() {
        return new HelpFragment();
    }

    private HelpAdapter adapter;
    private HelpPresenter helpPresenter;

    private int lowUrgency, mediumUrgency, highUrgency, otherUrgency;

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
        initializeUI();
        initializeAdapter();
        initializeRecyclerView();
        initSwipe();
        loadData();
    }

    public void loadData() {
        helpPresenter.loadHelpList();
    }

    private void initializeUI() {
        // hide results to avoid crashing the app
        helpResultsLL.setVisibility(View.GONE);
    }

    private void initializeAdapter() {
        adapter = new HelpAdapter(helpPresenter);
    }

    private void initializeRecyclerView() {
        GridLayoutManager lLayout = new GridLayoutManager(getActivity(), 1);
        recycler_help.setNestedScrollingEnabled(false);
        recycler_help.setLayoutManager(lLayout);
        recycler_help.setAdapter(adapter);
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

    // Dialog displaying the number of results per level of urgency
    private void showHelpInfo() {
        AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final ViewGroup vg = null;
        final View view = inflater.inflate(R.layout.help_results_dialog, vg);
        TextView lowTV = view.findViewById(R.id.help_info_low_tv);
        TextView highTV = view.findViewById(R.id.help_info_high_tv);
        TextView otherTV = view.findViewById(R.id.help_info_other_tv);
        TextView mediumTV = view.findViewById(R.id.help_info_medium_tv);

        otherTV.setText(new StringBuilder("Otra: ").append(otherUrgency));
        lowTV.setText(new StringBuilder("Urgencia Baja: ").append(lowUrgency));
        highTV.setText(new StringBuilder("Urgencia Alta: ").append(highUrgency));
        mediumTV.setText(new StringBuilder("Urgencia Media: ").append(mediumUrgency));

        alert.setTitle("Total de Ayuda Requerida por Nivel de Urgencia");
        alert.setNegativeButton("Cerrar", new DialogInterface.OnClickListener() {
            @Override public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        alert.setView(view);
        alert.show();
    }

    // on click listener to show dialog above
    @OnClick(R.id.help_results_ll) public void onClickResults() {
        showHelpInfo();
    }

    @Override public void showHelpList(List<Help> helpList) {
        adapter.setHelpList(helpList);

        // after displaying the list, show total results so user can click on it
        helpResultsLL.setVisibility(View.VISIBLE);

        // display total number of results
        helpResultsTV.setText(new StringBuilder("Resultados: ").append(helpList.size()));

        // count number of results per level of emergency (alto, medio, and bajo)
        for (Help help : helpList) {
            String urgency = help.getLevelOfUrgency();
            if (urgency != null) {
                if (urgency.toLowerCase().equals("alto")) {
                    highUrgency++;
                } else if (urgency.toLowerCase().equals("medio")) {
                    mediumUrgency++;
                } else if (urgency.toLowerCase().equals("bajo")) {
                    lowUrgency++;
                } else {
                    otherUrgency++;
                }
            }
        }
    }

    @Override public void showEmptyMessage() {
        Toast.makeText(getContext(), "No se ha encontrado información", Toast.LENGTH_LONG).show();
    }

    @Override public void showErrorMessage() {
        Toast.makeText(getContext(), "Ha Ocurrido un error", Toast.LENGTH_LONG).show();
    }

    @Override public void showDetails(Help help) {
        if (help.getLinkMaps() != null && !help.getLinkMaps().isEmpty()) {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(help.getLinkMaps()));
            startActivity(i);
        } else {
            showEmptyMessage();
        }
    }

    @Override public void share(String message) {
        ShareCompat.IntentBuilder.from(getActivity()).setType("text/plain").setText(message).startChooser();
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

    private int getColor(int color) {
        return ContextCompat.getColor(getActivity(), color);
    }
}
