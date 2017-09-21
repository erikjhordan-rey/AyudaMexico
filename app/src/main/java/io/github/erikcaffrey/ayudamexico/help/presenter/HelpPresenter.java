package io.github.erikcaffrey.ayudamexico.help.presenter;

import erikjhordanrey.base_components.view.BasePresenter;
import erikjhordanrey.base_components.view.BasePresenterLoader;
import io.github.erikcaffrey.ayudamexico.help.model.Help;
import io.github.erikcaffrey.ayudamexico.help.model.HelpInteractor;
import io.reactivex.functions.Consumer;
import java.util.List;

public class HelpPresenter extends BasePresenter<HelpPresenter.Ui> {

    private final HelpInteractor helpInteractor;

    public HelpPresenter(HelpInteractor helpInteractor) {
        this.helpInteractor = helpInteractor;
    }

    public void loadHelpList() {
        this.helpInteractor.getHelpList().subscribe(new Consumer<List<Help>>() {
            @Override public void accept(List<Help> helps) throws Exception {
                if (!helps.isEmpty() && helps.size() > 0) {
                    getUi().hideLoading();
                    getUi().showHelpList(helps);
                } else {
                    getUi().showEmptyMessage();
                }
            }
        }, new Consumer<Throwable>() {
            @Override public void accept(Throwable throwable) throws Exception {
                throwable.printStackTrace();
                getUi().showErrorMessage();
            }
        });
    }

    public interface Ui extends BasePresenterLoader.Ui {

        void showHelpList(List<Help> helpList);

        void showEmptyMessage();

        void showErrorMessage();
    }
}
