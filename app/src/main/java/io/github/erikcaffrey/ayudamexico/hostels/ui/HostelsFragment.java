package io.github.erikcaffrey.ayudamexico.hostels.ui;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Toast;
import io.github.erikcaffrey.ayudamexico.R;
import io.github.erikcaffrey.ayudamexico.common.CoreFragment;
import io.github.erikcaffrey.ayudamexico.hostels.model.Hostel;
import io.github.erikcaffrey.ayudamexico.hostels.model.HostelClient;
import io.github.erikcaffrey.ayudamexico.hostels.model.HostelInteractor;
import io.github.erikcaffrey.ayudamexico.hostels.presenter.HostelPresenter;
import java.util.List;

public class HostelsFragment extends CoreFragment implements HostelPresenter.Ui {

    public static HostelsFragment newInstance() {
        return new HostelsFragment();
    }

    private HostelPresenter hostelPresenter;

    @Override protected int getLayoutResId() {
        return R.layout.hostels_fragment;
    }

    @Override protected void initPresenter() {
        super.initPresenter();
        final HostelClient hostelClient = new HostelClient();
        final HostelInteractor hostelInteractor = new HostelInteractor(hostelClient);
        hostelPresenter = new HostelPresenter(hostelInteractor);
        hostelPresenter.setUi(this);
    }

    @Override protected void initFragment(@NonNull View view) {
        super.initFragment(view);
        hostelPresenter.loadHostelList();
    }

    @Override public void showHostelList(List<Hostel> hostelList) {
        for (Hostel hostel : hostelList) {
            System.out.println(hostel.getPlace());
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
}
