package io.github.erikcaffrey.ayudamexico.centers.rescatemx.service;

import io.github.erikcaffrey.ayudamexico.centers.rescatemx.model.RescateMX;
import io.reactivex.Observable;

public interface RescateMXService {
    Observable<RescateMX> getCenterList();
}
