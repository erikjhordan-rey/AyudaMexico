package io.github.erikcaffrey.ayudamexico.support.ui;

import android.os.Bundle;

import io.github.erikcaffrey.ayudamexico.common.BaseAdapter;
import io.github.erikcaffrey.ayudamexico.common.ListPresenter;
import io.github.erikcaffrey.ayudamexico.common.SimpleListFragment;
import io.github.erikcaffrey.ayudamexico.support.model.SupportClient;
import io.github.erikcaffrey.ayudamexico.support.model.SupportInteractor;
import io.github.erikcaffrey.ayudamexico.support.model.SupportService;
import io.github.erikcaffrey.ayudamexico.support.model.SupportSpot;
import io.github.erikcaffrey.ayudamexico.support.presenter.SupportPresenter;

/**
 * Created by silmood on 9/24/17.
 */

public class SupportFragment extends SimpleListFragment<SupportSpot>{

    public static SupportFragment newInstance() {

        Bundle args = new Bundle();

        SupportFragment fragment = new SupportFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void showDetails(SupportSpot item) {

    }


    @Override
    public ListPresenter getListPresenter() {
        SupportClient client = new SupportClient();
        SupportInteractor interactor = new SupportInteractor(client);
        return new SupportPresenter(interactor);
    }

    @Override
    public BaseAdapter<SupportSpot> getAdapter() {
        return new SupportSpotAdapter();
    }
}
