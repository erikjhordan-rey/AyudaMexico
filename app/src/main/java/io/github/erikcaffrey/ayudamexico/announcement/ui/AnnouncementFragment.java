package io.github.erikcaffrey.ayudamexico.announcement.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import java.util.List;

import butterknife.OnClick;
import io.github.erikcaffrey.ayudamexico.R;
import io.github.erikcaffrey.ayudamexico.announcement.model.Announcement;
import io.github.erikcaffrey.ayudamexico.announcement.model.AnnouncementClient;
import io.github.erikcaffrey.ayudamexico.announcement.model.AnnouncementInteractor;
import io.github.erikcaffrey.ayudamexico.announcement.presenter.AnnouncementPresenter;
import io.github.erikcaffrey.ayudamexico.common.BaseAdapter;
import io.github.erikcaffrey.ayudamexico.common.CoreFragment;
import io.github.erikcaffrey.ayudamexico.common.ListPresenter;
import io.github.erikcaffrey.ayudamexico.common.SimpleListFragment;
import io.github.erikcaffrey.ayudamexico.common.SimpleListUi;

public class AnnouncementFragment extends SimpleListFragment<Announcement>{

    public static AnnouncementFragment newInstance() {
        Bundle args = new Bundle();

        AnnouncementFragment fragment = new AnnouncementFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void showDetails(Announcement item) {

    }

    @Override
    public ListPresenter getListPresenter() {
        AnnouncementClient client = new AnnouncementClient();
        AnnouncementInteractor interactor = new AnnouncementInteractor(client);
        return new AnnouncementPresenter(interactor);
    }

    @Override
    public BaseAdapter<Announcement> getAdapter() {
        return new AnnouncementAdapter();
    }
}
