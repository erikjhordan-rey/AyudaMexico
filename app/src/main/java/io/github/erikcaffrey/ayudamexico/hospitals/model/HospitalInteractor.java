package io.github.erikcaffrey.ayudamexico.hospitals.model;

import java.util.List;

import io.reactivex.Observable;

public class HospitalInteractor {

    private final HospitalService hospitalService;

    public HospitalInteractor(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    public Observable<List<Hospital>> getHospitalList() {
        return hospitalService.getHospitalList();
    }
}
