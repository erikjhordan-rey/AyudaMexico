package io.github.erikcaffrey.ayudamexico.centers.gathering.model;

import java.util.List;

import io.reactivex.Observable;

public class CenterInteractor {

    private final CenterService centerService;

    public CenterInteractor(CenterService centerService) {
        this.centerService = centerService;
    }

    public Observable<List<Center>> getCenterList() {
        return centerService.getCentersList();
    }
}
