package io.github.erikcaffrey.ayudamexico.support.model;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by silmood on 9/24/17.
 */

public interface SupportService {

    Observable<List<SupportSpot>> getSupportSpots();
}
