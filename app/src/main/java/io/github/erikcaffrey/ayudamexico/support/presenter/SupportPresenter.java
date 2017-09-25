package io.github.erikcaffrey.ayudamexico.support.presenter;

import io.github.erikcaffrey.ayudamexico.common.ListPresenter;
import io.github.erikcaffrey.ayudamexico.support.model.SupportSpot;
import io.github.erikcaffrey.ayudamexico.support.model.SupportInteractor;

/**
 * Created by silmood on 9/24/17.
 */


public class SupportPresenter extends ListPresenter<SupportInteractor, SupportSpot>{
    public SupportPresenter(SupportInteractor interactor) {
        super(interactor);
    }
}
