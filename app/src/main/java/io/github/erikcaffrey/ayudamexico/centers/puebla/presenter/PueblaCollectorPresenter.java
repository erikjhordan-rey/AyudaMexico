package io.github.erikcaffrey.ayudamexico.centers.puebla.presenter;

import java.util.List;

import io.github.erikcaffrey.ayudamexico.centers.puebla.model.CollectorCenter;
import io.github.erikcaffrey.ayudamexico.centers.puebla.service.CollectorCentersClient;
import io.github.erikcaffrey.ayudamexico.centers.puebla.view.PueblaCollectorView;

/**
 * Created by Armando on 24/9/2017.
 */

public class PueblaCollectorPresenter implements PueblaCollectorPresenterContract{
    private final PueblaCollectorView view;
    private final CollectorCentersClient client;

    public PueblaCollectorPresenter(PueblaCollectorView view) {
        this.view = view;
        this.client = new CollectorCentersClient(this);
    }

    public void loadCollectorCenter() {
        client.getPueblaCollectorCenters();
    }

    @Override
    public void processCollectorCenters(List<CollectorCenter> collectorCenters) {
        view.showCollectorCenters(collectorCenters);
    }
}
