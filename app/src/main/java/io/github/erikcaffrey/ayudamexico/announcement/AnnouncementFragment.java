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

    @OnClick({ R.id.card_risky_url, R.id.risky_url }) public void buildings_url() {
        openLink("https://goo.gl/8aJwqB");
    }

    @OnClick({ R.id.card_ado_url, R.id.ado_url }) public void ado_url() {
        openLink("https://goo.gl/y5bd5c");
    }

    @OnClick({ R.id.card_aero_url, R.id.aero_url }) public void aero_url() {
        openLink("https://goo.gl/HBCQMN");
    }

    @OnClick({ R.id.card_vans_url, R.id.vans_url }) public void vans_url() {
        openLink("https://goo.gl/MryZd6");
    }

    @OnClick({ R.id.card_modelo_url, R.id.modelo_url }) public void modelo_url() {
        openLink("https://goo.gl/owYCdb");
    }

    @OnClick({ R.id.card_wings_url, R.id.wings_url }) public void wings_url() {
        openLink("https://goo.gl/1JWiks");
    }

    @OnClick({ R.id.card_list_url, R.id.list_url }) public void list_url() {
        openLink("https://goo.gl/f4MuBF");
    }

    @OnClick(R.id.list_1_url) public void list1_url() {
        openLink("https://goo.gl/af31WD");
    }

    @OnClick({ R.id.card_sismo_url, R.id.sismo_url }) public void sismo_url() {
        openLink("https://goo.gl/Zfxcas");
    }

    @OnClick({ R.id.card_classes_url, R.id.classes_url }) public void classes_url() {
        openLink("https://goo.gl/Q6hHSQ");
    }

    @OnClick({ R.id.card_pisa_url, R.id.pisa_url }) public void pisa_url() {
        openLink("https://goo.gl/GWg9WX");
    }

    @OnClick({ R.id.card_sable_url, R.id.sable_url }) public void sable_url() {
        openLink("https://goo.gl/5USvmH");
    }

    public void openLink(String url) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}
