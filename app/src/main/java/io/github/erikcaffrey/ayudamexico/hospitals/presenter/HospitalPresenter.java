package io.github.erikcaffrey.ayudamexico.hospitals.presenter;

import java.util.List;

import erikjhordanrey.base_components.view.BasePresenter;
import erikjhordanrey.base_components.view.BasePresenterLoader;
import io.github.erikcaffrey.ayudamexico.hospitals.model.Hospital;
import io.github.erikcaffrey.ayudamexico.hospitals.model.HospitalInteractor;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class HospitalPresenter extends BasePresenter<HospitalPresenter.Ui> {

    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    private final HospitalInteractor hospitalInteractor;


    public HospitalPresenter(HospitalInteractor hospitalInteractor) {
        this.hospitalInteractor = hospitalInteractor;
    }

    public void loadHospitalList() {
        getUi().showLoading();
        Disposable disposable = this.hospitalInteractor.getHospitalList().subscribe(new Consumer<List<Hospital>>() {
            @Override public void accept(List<Hospital> helps) throws Exception {
                if (!helps.isEmpty() && helps.size() > 0) {
                    getUi().hideLoading();
                    getUi().showHospitalList(helps);
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

        void showHospitalList(List<Hospital> helpList);

        void showEmptyMessage();

        void showErrorMessage();

        void showDetails(Hospital hospital);
    }
}
