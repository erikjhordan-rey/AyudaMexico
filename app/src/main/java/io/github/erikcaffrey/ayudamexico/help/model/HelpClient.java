package io.github.erikcaffrey.ayudamexico.help.model;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

public class HelpClient extends HelpRetrofitClient implements HelpService {

    @Override public Observable<List<Help>> getHelpList() {
        return getService().getHelpList(HELP_URL).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
