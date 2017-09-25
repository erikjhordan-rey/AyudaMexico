package io.github.erikcaffrey.ayudamexico.support.model;

import java.util.List;

import io.github.erikcaffrey.ayudamexico.announcement.model.AnnouncementService;
import io.github.erikcaffrey.ayudamexico.common.ListInteractor;
import io.reactivex.Observable;

/**
 * Created by silmood on 9/24/17.
 */

public class SupportInteractor implements ListInteractor<SupportSpot>{

    private final SupportService service;

    public SupportInteractor(SupportService service) {
        this.service = service;
    }

    @Override
    public Observable<List<SupportSpot>> getItems() {
        return service.getSupportSpots();
    }
}
