package io.github.erikcaffrey.ayudamexico.centers.puebla.service;

import io.github.erikcaffrey.ayudamexico.centers.puebla.service.dto.puebla.CollectorCenterDto;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Armando on 24/9/2017.
 */

public interface CollectorCenterRetrofitService {
    @GET("?dataset=centros-de-acopio-puebla&facet=informacion_sobre_centros_de_acopio_en_puebla&facet=column_5")
    Call<CollectorCenterDto> getPueblaCollectorCenters();
}
