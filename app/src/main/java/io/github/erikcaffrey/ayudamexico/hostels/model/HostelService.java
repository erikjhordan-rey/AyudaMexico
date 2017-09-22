package io.github.erikcaffrey.ayudamexico.hostels.model;

import io.reactivex.Observable;
import java.util.List;

public interface HostelService {
    Observable<List<Hostel>> getHostelList();
}
