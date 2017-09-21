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

public class AreasFragment extends CoreFragment {

    public static AreasFragment newInstance() {
        return new AreasFragment();
    }

    private static final String AFFECTED_AREAS_URL =
        "https://www.google.com/maps/d/u/0/viewer?mid=13B_gbt3e5RWk_6xQoQ15xxhGOFs&ll=19.339332910595843%2C-99.07649944863283&z=11";

    @BindView(R.id.web_view_affected_areas) WebView affectedAreas;
    @BindView(R.id.progress) ProgressBar progress;

    @Override protected int getLayoutResId() {
        return R.layout.areas_fragment;
    }

    @Override protected void initFragment(@NonNull View view) {
        super.initFragment(view);
        initWebViewPeopleFinder();
    }

    private void initWebViewPeopleFinder() {
        affectedAreas.loadUrl(AFFECTED_AREAS_URL);
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

    @Override public void onDestroy() {
        if (affectedAreas != null) {
            affectedAreas.stopLoading();
        }
        super.onDestroy();
    }
}
