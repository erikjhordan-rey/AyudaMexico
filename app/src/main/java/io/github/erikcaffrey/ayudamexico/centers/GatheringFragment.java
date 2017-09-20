package io.github.erikcaffrey.ayudamexico.centers;

import android.content.Intent;
import android.net.Uri;
import butterknife.OnClick;
import io.github.erikcaffrey.ayudamexico.R;
import io.github.erikcaffrey.ayudamexico.common.CoreFragment;

public class GatheringFragment extends CoreFragment {

    public static GatheringFragment newInstance() {
        return new GatheringFragment();
    }

    @Override protected int getLayoutResId() {
        return R.layout.gathering_fragment;
    }

    @OnClick(R.id.gathering_url ) public void hospital_url() {
        openLink("https://goo.gl/TrN68T");
    }

    @OnClick(R.id.morelos_url ) public void morelos_url() {
        openLink("https://goo.gl/opR3Vg");
    }

    public void openLink(String url) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}
