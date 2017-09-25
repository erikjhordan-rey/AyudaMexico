package io.github.erikcaffrey.ayudamexico.centers.puebla.view;

import erikjhordanrey.base_components.view.BasePresenterLoader;
import java.util.List;

import io.github.erikcaffrey.ayudamexico.centers.puebla.model.CollectorCenter;

/**
 * Created by Armando on 24/9/2017.
 */

public interface PueblaCollectorView extends BasePresenterLoader.Ui{
    void showCollectorCenters(List<CollectorCenter> collectorCenters);

    void showEmptyMessage();

    void showErrorMessage();
}
