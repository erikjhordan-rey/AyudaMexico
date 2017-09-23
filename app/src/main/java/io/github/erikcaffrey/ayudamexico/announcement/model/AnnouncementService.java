package io.github.erikcaffrey.ayudamexico.announcement.model;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by silmood on 9/22/17.
 */

public interface AnnouncementService {
    Observable<List<Announcement>> getAnnouncements();
}
