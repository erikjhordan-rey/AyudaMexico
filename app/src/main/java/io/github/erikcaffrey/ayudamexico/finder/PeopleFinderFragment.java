package io.github.erikcaffrey.ayudamexico.finder;

import android.support.annotation.NonNull;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import butterknife.BindView;
import io.github.erikcaffrey.ayudamexico.R;
import io.github.erikcaffrey.ayudamexico.common.CoreFragment;

public class PeopleFinderFragment extends CoreFragment {

    public static PeopleFinderFragment newInstance() {
        return new PeopleFinderFragment();
    }

    private static final String PERSON_FINDER_URL = "https://google.org/personfinder/2017-puebla-mexico-earthquake";

    @BindView(R.id.web_view_people_finder) WebView peopleFinder;
    @BindView(R.id.progress) ProgressBar progress;

    @Override protected int getLayoutResId() {
        return R.layout.people_finder_fragment;
    }

    @Override protected void initFragment(@NonNull View view) {
        super.initFragment(view);
        initWebViewPeopleFinder();
    }

    private void initWebViewPeopleFinder() {
        peopleFinder.loadUrl(PERSON_FINDER_URL);
        WebSettings webSettings = peopleFinder.getSettings();
        webSettings.setJavaScriptEnabled(true);
        peopleFinder.setWebViewClient(new WebViewClient() {
            @Override public void onPageFinished(WebView view, String url) {

                if (progress != null) {
                    progress.setVisibility(View.GONE);
                }

                if (peopleFinder != null) {
                    peopleFinder.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    @Override public void onDestroy() {
        if (peopleFinder != null) {
            peopleFinder.stopLoading();
        }
        super.onDestroy();
    }
}
