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

public class RealTimeFragment extends CoreFragment {

    public static RealTimeFragment newInstance() {
        return new RealTimeFragment();
    }

    private static final String REAL_TIME_URL =
        "https://www.google.com/maps/d/u/0/viewer?mid=1PwJrCIjz5PNfKAFrY-EX-iEkWH8&ll=19.442351448840228%2C-99.21630083720703&z=12";

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
        realTimeWebView.loadUrl(REAL_TIME_URL);
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
}
