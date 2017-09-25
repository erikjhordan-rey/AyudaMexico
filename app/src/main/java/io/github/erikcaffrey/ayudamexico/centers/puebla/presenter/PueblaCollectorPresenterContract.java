package io.github.erikcaffrey.ayudamexico.centers.puebla.presenter;

import java.util.List;

import io.github.erikcaffrey.ayudamexico.centers.puebla.model.CollectorCenter;

/**
 * Created by Armando on 24/9/2017.
 */

public interface PueblaCollectorPresenterContract {
    void processCollectorCenters(List<CollectorCenter> collectorCenters);
}
