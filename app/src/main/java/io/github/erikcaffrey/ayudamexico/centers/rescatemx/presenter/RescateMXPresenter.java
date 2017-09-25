package io.github.erikcaffrey.ayudamexico.centers.rescatemx.presenter;

import java.util.List;

import erikjhordanrey.base_components.view.BasePresenter;
import erikjhordanrey.base_components.view.BasePresenterLoader;
import io.github.erikcaffrey.ayudamexico.centers.rescatemx.model.Record;
import io.github.erikcaffrey.ayudamexico.centers.rescatemx.model.RescateMX;
import io.github.erikcaffrey.ayudamexico.centers.rescatemx.service.RescateMXInteractor;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class RescateMXPresenter extends BasePresenter<RescateMXPresenter.Ui> {

    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    private final RescateMXInteractor rescateMXInteractor;


    public RescateMXPresenter(RescateMXInteractor rescateMXInteractor) {
        this.rescateMXInteractor = rescateMXInteractor;
    }

    public void loadHospitalList() {
        getUi().showLoading();
        Disposable disposable = this.rescateMXInteractor.getCenterList().subscribe(new Consumer<RescateMX>() {
            @Override public void accept(RescateMX rescateMX) throws Exception {

                if (!rescateMX.getRecords().isEmpty() && rescateMX.getRecords().size() > 0) {
                    getUi().hideLoading();
                    getUi().showRescateMXList(rescateMX.getRecords());
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

    public void onItemClick(Record record) {
        getUi().showDetails(record);
    }

    public interface Ui extends BasePresenterLoader.Ui {

        void showRescateMXList(List<Record> helpList);

        void showEmptyMessage();

        void showErrorMessage();

        void showDetails(Record hospital);
    }
}
