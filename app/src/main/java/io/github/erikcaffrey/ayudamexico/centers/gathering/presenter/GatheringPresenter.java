package io.github.erikcaffrey.ayudamexico.centers.gathering.presenter;

import java.util.List;

import erikjhordanrey.base_components.view.BasePresenter;
import erikjhordanrey.base_components.view.BasePresenterLoader;
import io.github.erikcaffrey.ayudamexico.centers.gathering.model.Center;
import io.github.erikcaffrey.ayudamexico.centers.gathering.model.CenterInteractor;
import io.github.erikcaffrey.ayudamexico.hospitals.model.Hospital;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by silmood on 9/21/17.
 */

public class GatheringPresenter extends BasePresenter<GatheringPresenter.Ui>{
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    private final CenterInteractor centerInteractor;


    public GatheringPresenter(CenterInteractor centerInteractor) {
        this.centerInteractor = centerInteractor;
    }

    public void loadCentersList() {
        getUi().showLoading();
        Disposable disposable = this.centerInteractor.getCenterList().subscribe(new Consumer<List<Center>>() {
            @Override public void accept(List<Center> helps) throws Exception {
                if (!helps.isEmpty() && helps.size() > 0) {
                    getUi().hideLoading();
                    getUi().showCentersList(helps);
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

    public void onItemClick(Hospital hospital) {
        getUi().showDetails(hospital);
    }

    public interface Ui extends BasePresenterLoader.Ui {

        void showCentersList(List<Center> centersList);

        void showEmptyMessage();

        void showErrorMessage();

        void showDetails(Hospital hospital);
    }
}
