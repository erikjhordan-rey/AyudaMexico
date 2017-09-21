package io.github.erikcaffrey.ayudamexico.hospitals.model;

import java.util.List;

import io.reactivex.Observable;

public interface HospitalService {
    Observable<List<Hospital>> getHospitalList();
}
