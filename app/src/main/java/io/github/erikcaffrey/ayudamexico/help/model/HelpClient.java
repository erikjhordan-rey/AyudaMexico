package io.github.erikcaffrey.ayudamexico.help.model;

import io.github.erikcaffrey.ayudamexico.common.BaseRetrofitClient;
import io.github.erikcaffrey.ayudamexico.common.Constans;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

public class HelpClient extends BaseRetrofitClient<HelpRetrofitService> implements HelpService {

    @Override public Observable<List<Help>> getHelpList() {
        return service.getHelpList(Constans.HELP_URL).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
