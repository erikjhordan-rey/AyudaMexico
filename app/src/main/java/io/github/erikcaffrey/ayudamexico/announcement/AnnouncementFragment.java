package io.github.erikcaffrey.ayudamexico.announcement;

import android.content.Intent;
import android.net.Uri;
import butterknife.OnClick;
import io.github.erikcaffrey.ayudamexico.R;
import io.github.erikcaffrey.ayudamexico.common.CoreFragment;

public class AnnouncementFragment extends CoreFragment {

    public static AnnouncementFragment newInstance() {
        return new AnnouncementFragment();
    }

    @Override protected int getLayoutResId() {
        return R.layout.announcement_fragment;
    }

    @OnClick({ R.id.etn_url, R.id.card_etn_url }) public void etn_url() {
        openLink("https://goo.gl/HfH3Qv");
    }

    @OnClick({ R.id.anima_url, R.id.card_anima_url }) public void anima_url() {
        openLink("https://goo.gl/Vj7xah");
    }

    @OnClick({ R.id.telcel_url, R.id.card_telcel_url }) public void telcel_url() {
        openLink("https://goo.gl/a5wHEf");
    }

    @OnClick({ R.id.startup_url, R.id.card_startup_url }) public void startup_url() {
        openLink("https://goo.gl/P54YT7");
    }

    @OnClick({ R.id.hospital_url, R.id.card_makin_url }) public void hospital_url() {
        openLink("https://goo.gl/18c35s");
    }

    public void openLink(String url) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}
