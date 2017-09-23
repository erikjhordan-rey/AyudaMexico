package io.github.erikcaffrey.ayudamexico.common;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by silmood on 9/22/17.
 */

public interface ListInteractor<MODEL> {
    Observable<List<MODEL>> getItems();
}
