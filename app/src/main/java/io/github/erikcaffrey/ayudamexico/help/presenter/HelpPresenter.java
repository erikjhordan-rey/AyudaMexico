package io.github.erikcaffrey.ayudamexico.help.presenter;

import java.util.List;

import erikjhordanrey.base_components.view.BasePresenter;
import erikjhordanrey.base_components.view.BasePresenterLoader;
import io.github.erikcaffrey.ayudamexico.help.model.Help;
import io.github.erikcaffrey.ayudamexico.help.model.HelpInteractor;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class HelpPresenter extends BasePresenter<HelpPresenter.Ui> {

    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    private final HelpInteractor helpInteractor;


    public HelpPresenter(HelpInteractor helpInteractor) {
        this.helpInteractor = helpInteractor;
    }

    public void loadHelpList() {
        getUi().showLoading();
        Disposable disposable = this.helpInteractor.getHelpList().subscribe(new Consumer<List<Help>>() {
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

        compositeDisposable.add(disposable);
    }

    @Override public void terminate() {
        super.terminate();
        compositeDisposable.clear();
    }

    public void onItemClick(Help help) {
        getUi().showDetails(help);
    }

    public interface Ui extends BasePresenterLoader.Ui {

        void showHelpList(List<Help> helpList);

        void showEmptyMessage();

        void showErrorMessage();

        void showDetails(Help help);
    }
}
