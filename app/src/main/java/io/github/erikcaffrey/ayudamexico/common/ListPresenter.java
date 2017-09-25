package io.github.erikcaffrey.ayudamexico.common;

import java.util.List;

import erikjhordanrey.base_components.view.BasePresenter;
import io.github.erikcaffrey.ayudamexico.announcement.model.Announcement;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by silmood on 9/22/17.
 */

public class ListPresenter<INTERACTOR extends ListInteractor<MODEL>, MODEL> extends BasePresenter<SimpleListUi<MODEL>>{

    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    private final INTERACTOR interactor;

    public ListPresenter(INTERACTOR interactor) {
        this.interactor = interactor;
    }

    public void loadList() {
        getUi().showLoading();
        Disposable disposable = this.interactor.getItems().subscribe(new Consumer<List<MODEL>>() {
            @Override public void accept(List<MODEL> items) throws Exception {
                if (!items.isEmpty() && items.size() > 0) {
                    getUi().hideLoading();
                    getUi().showList(items);
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

}
