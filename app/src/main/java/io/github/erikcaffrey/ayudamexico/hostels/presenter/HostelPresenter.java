package io.github.erikcaffrey.ayudamexico.hostels.presenter;

import erikjhordanrey.base_components.view.BasePresenter;
import erikjhordanrey.base_components.view.BasePresenterLoader;
import io.github.erikcaffrey.ayudamexico.hostels.model.Hostel;
import io.github.erikcaffrey.ayudamexico.hostels.model.HostelInteractor;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;

public class HostelPresenter extends BasePresenter<HostelPresenter.Ui> {

    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    private final HostelInteractor hostelInteractor;

    public HostelPresenter(HostelInteractor hostelInteractor) {
        this.hostelInteractor = hostelInteractor;
    }

    public void loadHostelList() {
        getUi().showLoading();
        Disposable disposable = this.hostelInteractor.getHostelList().subscribe(new Consumer<List<Hostel>>() {
            @Override public void accept(List<Hostel> hostels) throws Exception {
                if (!hostels.isEmpty() && hostels.size() > 0) {
                    getUi().hideLoading();
                    getUi().showHostelList(hostels);
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

    public interface Ui extends BasePresenterLoader.Ui {
        void showHostelList(List<Hostel> hostelList);

        void showEmptyMessage();

        void showErrorMessage();
    }
}
