package io.github.erikcaffrey.ayudamexico.announcement.ui;

import android.os.Bundle;
import android.support.v4.app.ShareCompat;

import io.github.erikcaffrey.ayudamexico.announcement.model.Announcement;
import io.github.erikcaffrey.ayudamexico.announcement.model.AnnouncementClient;
import io.github.erikcaffrey.ayudamexico.announcement.model.AnnouncementInteractor;
import io.github.erikcaffrey.ayudamexico.announcement.presenter.AnnouncementPresenter;
import io.github.erikcaffrey.ayudamexico.common.BaseAdapter;
import io.github.erikcaffrey.ayudamexico.common.ListPresenter;
import io.github.erikcaffrey.ayudamexico.common.SimpleListFragment;

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
    public void shareAnnouncement(String message) {
        ShareCompat.IntentBuilder.from(getActivity()).setType("text/plain").setText(message).startChooser();
    }

    @Override
    public ListPresenter getListPresenter() {
        AnnouncementClient client = new AnnouncementClient();
        AnnouncementInteractor interactor = new AnnouncementInteractor(client);
        return new AnnouncementPresenter(interactor);
    }

    @Override
    public BaseAdapter<Announcement> getAdapter() {
        AnnouncementAdapter announcementAdapter =  new AnnouncementAdapter();
        announcementAdapter.setActivity(getActivity());//its neccesary for share Announcement
        return announcementAdapter;
    }
}
