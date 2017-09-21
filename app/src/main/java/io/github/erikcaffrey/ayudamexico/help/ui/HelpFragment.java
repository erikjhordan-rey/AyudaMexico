package io.github.erikcaffrey.ayudamexico.help.ui;

import android.widget.Toast;
import io.github.erikcaffrey.ayudamexico.R;
import io.github.erikcaffrey.ayudamexico.common.CoreFragment;
import io.github.erikcaffrey.ayudamexico.help.model.Help;
import io.github.erikcaffrey.ayudamexico.help.model.HelpClient;
import io.github.erikcaffrey.ayudamexico.help.model.HelpInteractor;
import io.github.erikcaffrey.ayudamexico.help.presenter.HelpPresenter;
import java.util.List;

public class HelpFragment extends CoreFragment implements HelpPresenter.Ui {

    public static HelpFragment newInstance() {
        return new HelpFragment();
    }

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
        helpPresenter.loadHelpList();
    }

    @Override public void showHelpList(List<Help> helpList) {
        for (Help help : helpList) {
            System.out.println(help.getLevelOfUrgency());
        }
    }

    @Override public void showEmptyMessage() {
        Toast.makeText(getContext(), "No se ha encontrado información", Toast.LENGTH_LONG).show();
    }

    @Override public void showErrorMessage() {
        Toast.makeText(getContext(), "Ha Ocurrido un error", Toast.LENGTH_LONG).show();
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
