package io.github.erikcaffrey.ayudamexico.help.model;

import io.reactivex.Observable;
import java.util.List;

public interface HelpService {
    Observable<List<Help>> getHelpList();
}
