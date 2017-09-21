package io.github.erikcaffrey.ayudamexico.areas;

import android.support.annotation.NonNull;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import butterknife.BindView;
import io.github.erikcaffrey.ayudamexico.R;
import io.github.erikcaffrey.ayudamexico.common.CoreFragment;

public abstract class MapFragment extends CoreFragment {

    @BindView(R.id.web_view_map) WebView affectedAreas;
    @BindView(R.id.progress) ProgressBar progress;

    @Override protected int getLayoutResId() {
        return R.layout.web_view_map_fragment;
    }

    @Override protected void initFragment(@NonNull View view) {
        super.initFragment(view);
        initWebViewPeopleFinder();
    }

    private void initWebViewPeopleFinder() {
        affectedAreas.loadUrl(getAffectedAreasUrl());
        WebSettings webSettings = affectedAreas.getSettings();
        webSettings.setJavaScriptEnabled(true);
        affectedAreas.setWebViewClient(new WebViewClient() {
            @Override public void onPageFinished(WebView view, String url) {

                if (progress != null) {
                    progress.setVisibility(View.GONE);
                }

                if (affectedAreas != null) {
                    affectedAreas.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    abstract String getAffectedAreasUrl();
}
