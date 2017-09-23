package io.github.erikcaffrey.ayudamexico.announcement.presenter;

import java.util.List;

import erikjhordanrey.base_components.view.BasePresenter;
import io.github.erikcaffrey.ayudamexico.announcement.model.Announcement;
import io.github.erikcaffrey.ayudamexico.announcement.model.AnnouncementInteractor;
import io.github.erikcaffrey.ayudamexico.common.ListPresenter;
import io.github.erikcaffrey.ayudamexico.common.SimpleListUi;
import io.github.erikcaffrey.ayudamexico.help.model.Help;
import io.github.erikcaffrey.ayudamexico.help.model.HelpInteractor;
import io.github.erikcaffrey.ayudamexico.help.presenter.HelpPresenter;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by silmood on 9/22/17.
 */

public class AnnouncementPresenter extends ListPresenter<AnnouncementInteractor, Announcement> {
    public AnnouncementPresenter(AnnouncementInteractor interactor) {
        super(interactor);
    }
}
