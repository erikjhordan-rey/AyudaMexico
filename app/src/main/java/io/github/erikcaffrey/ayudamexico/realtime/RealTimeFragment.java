package io.github.erikcaffrey.ayudamexico.realtime;

import android.support.annotation.NonNull;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import butterknife.BindView;
import io.github.erikcaffrey.ayudamexico.R;
import io.github.erikcaffrey.ayudamexico.common.CoreFragment;

public abstract class RealTimeFragment extends CoreFragment {

    @BindView(R.id.web_view_map) WebView realTimeWebView;
    @BindView(R.id.progress) ProgressBar progress;

    @Override protected int getLayoutResId() {
        return R.layout.web_view_map_fragment;
    }

    @Override protected void initFragment(@NonNull View view) {
        super.initFragment(view);
        initWebViewPeopleFinder();
    }

    private void initWebViewPeopleFinder() {
        realTimeWebView.loadUrl(getAffectedAreasUrl());
        WebSettings webSettings = realTimeWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        realTimeWebView.setWebViewClient(new WebViewClient() {
            @Override public void onPageFinished(WebView view, String url) {

                if (progress != null) {
                    progress.setVisibility(View.GONE);
                }

                if (realTimeWebView != null) {
                    realTimeWebView.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    @Override public void onDestroy() {
        if (realTimeWebView != null) {
            realTimeWebView.stopLoading();
        }
        super.onDestroy();
    }

    abstract String getAffectedAreasUrl();

    class MapUrl {
        static final String CDMX =
            "https://www.google.com/maps/d/u/0/viewer?mid=1PwJrCIjz5PNfKAFrY-EX-iEkWH8&ll=19.442351448840228%2C-99.21630083720703&z=12";

        static final String VERIFICADOS =
            "https://www.google.com/maps/d/u/0/embed?mid=1_-V97lbdgLFHpx-CtqhLWlJAnYY&hl=en&ll=19.377859971973805%2C-99.15070127080776&z=8";
    }
}
