package io.github.erikcaffrey.ayudamexico.centers.puebla.service;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

import io.github.erikcaffrey.ayudamexico.centers.puebla.model.CollectorCenter;
import io.github.erikcaffrey.ayudamexico.centers.puebla.presenter.PueblaCollectorPresenterContract;
import io.github.erikcaffrey.ayudamexico.centers.puebla.service.dto.puebla.CollectorCenterDto;
import io.github.erikcaffrey.ayudamexico.centers.puebla.service.dto.puebla.Record;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Armando on 24/9/2017.
 */

public class CollectorCentersClient extends CollectorCenterRetrofitClient implements CollectorCenterService {

    private PueblaCollectorPresenterContract presenter;

    public CollectorCentersClient(PueblaCollectorPresenterContract presenter) {
        this.presenter = presenter;
    }

    public void getPueblaCollectorCenters() {
        Call<CollectorCenterDto> callable = CollectorCenterRetrofitClient.getApiService().getPueblaCollectorCenters();
        callable.enqueue(new Callback<CollectorCenterDto>() {
            @Override
            public void onResponse(Call<CollectorCenterDto> call, Response<CollectorCenterDto> response) {
                if(response.isSuccessful()){
                    List<CollectorCenter> collectorCenters = new ArrayList<CollectorCenter>();
                    List<Record> records = response.body().getRecords();
                    for (Record record :
                            records) {
                        CollectorCenter center = new CollectorCenter();
                        center.setName(record.getFields().getInformacionSobreCentrosDeAcopioEnPuebla());
                        center.setAsking(record.getFields().getColumn7());
                        String address = record.getFields().getColumn3();
                        if(!TextUtils.isEmpty(record.getFields().getColumn5())){
                            address.concat(" " + record.getFields().getColumn5());
                        }
                        center.setAddress(address);
                        center.setPhone(record.getFields().getColumn6());
                        List<Double> rawCoordinates = record.getFields().getColumn2();
                        if(rawCoordinates != null) {
                            center.setLatitude(rawCoordinates.get(0));
                            center.setLongitude(rawCoordinates.get(1));
                        }
                        collectorCenters.add(center);
                    }
                    presenter.processCollectorCenters(collectorCenters);
                }
            }

            @Override
            public void onFailure(Call<CollectorCenterDto> call, Throwable t) {

            }
        });
    }
}
