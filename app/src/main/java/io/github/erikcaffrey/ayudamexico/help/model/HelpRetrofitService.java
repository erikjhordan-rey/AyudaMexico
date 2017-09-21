package io.github.erikcaffrey.ayudamexico.help.model;

import io.reactivex.Observable;
import java.util.List;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface HelpRetrofitService {
    @GET
    Observable<List<Help>> getHelpList(@Url String url);
}
