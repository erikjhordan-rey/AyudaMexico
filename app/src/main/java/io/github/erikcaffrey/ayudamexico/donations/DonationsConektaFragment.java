package io.github.erikcaffrey.ayudamexico.donations;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.webkit.WebView;

import butterknife.BindView;
import io.github.erikcaffrey.ayudamexico.R;
import io.github.erikcaffrey.ayudamexico.common.CoreFragment;

/**
 * Created by armando on 9/22/17.
 */

public class DonationsConektaFragment extends CoreFragment {

    private static final String DONATIONS_CONEKTA_URL = "https://donativos.conekta.com/";

    @BindView(R.id.web_view_donations_conekta)
    WebView webView;

    public static Fragment newInstance() {
        return new DonationsConektaFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.donations_conekta_fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        webView.loadUrl(DONATIONS_CONEKTA_URL);
    }
}
