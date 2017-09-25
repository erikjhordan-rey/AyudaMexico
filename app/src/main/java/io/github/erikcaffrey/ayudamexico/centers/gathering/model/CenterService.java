package io.github.erikcaffrey.ayudamexico.centers.gathering.model;

import java.util.List;

import io.reactivex.Observable;

public interface CenterService {
    Observable<List<Center>> getCentersList();
}
