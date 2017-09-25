package io.github.erikcaffrey.ayudamexico.announcement.model;

import java.util.List;

import io.github.erikcaffrey.ayudamexico.common.ListInteractor;
import io.reactivex.Observable;

/**
 * Created by silmood on 9/22/17.
 */

public class AnnouncementInteractor implements ListInteractor<Announcement>{

    private final AnnouncementService service;

    public AnnouncementInteractor(AnnouncementService service) {
        this.service = service;
    }

    @Override
    public Observable<List<Announcement>> getItems() {
        return service.getAnnouncements();
    }
}
