package io.github.erikcaffrey.ayudamexico.centers.rescatemx.service;

import io.github.erikcaffrey.ayudamexico.centers.rescatemx.model.RescateMX;
import io.reactivex.Observable;

public class RescateMXInteractor {

    private final RescateMXService rescateMXService;

    public RescateMXInteractor(RescateMXService rescateMXService) {
        this.rescateMXService = rescateMXService;
    }

    public Observable<RescateMX> getCenterList() {
        return rescateMXService.getCenterList();
    }
}
