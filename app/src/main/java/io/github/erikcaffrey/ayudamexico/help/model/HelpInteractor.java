package io.github.erikcaffrey.ayudamexico.help.model;

import io.reactivex.Observable;
import java.util.List;

public class HelpInteractor {

    private final HelpService helpService;

    public HelpInteractor(HelpService helpService) {
        this.helpService = helpService;
    }

    public Observable<List<Help>> getHelpList() {
        return helpService.getHelpList();
    }
}
