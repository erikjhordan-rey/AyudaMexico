package io.github.erikcaffrey.ayudamexico.hostels.model;

import io.reactivex.Observable;
import java.util.List;

public class HostelInteractor {

    private HostelService hostelService;

    public HostelInteractor(HostelService hostelService) {
        this.hostelService = hostelService;
    }

    public Observable<List<Hostel>> getHostelList() {
        return hostelService.getHostelList();
    }
}
