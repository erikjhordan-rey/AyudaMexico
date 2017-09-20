package io.github.erikcaffrey.ayudamexico.donations;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.view.View;

import butterknife.OnClick;
import io.github.erikcaffrey.ayudamexico.R;
import io.github.erikcaffrey.ayudamexico.common.CoreFragment;

public class DonationsFragment extends CoreFragment {

    @Override
    protected void initFragment(@NonNull View view) {
        super.initFragment(view);
    }

    public static DonationsFragment newInstance() {
        return new DonationsFragment();
    }

    @Override protected int getLayoutResId() {
        return R.layout.donations_fragment;
    }



    @OnClick(R.id.card_topos_mx_url)
    public void card_topos_mx_url(){
        openLink("http://www.topos.mx/");
    }

    @OnClick(R.id.topos_mx_url)
    public void topos_mx_url(){
        openLink("http://www.topos.mx/");
    }

    @OnClick(R.id.topos_red_url)
    public void topos_red_url(){
        openLink("http://topos.red/");
    }

    @OnClick(R.id.cruz_roja_url)
    public void cruz_roja_url(){
        openLink("https://cruzrojadonaciones.org/");
    }

    @OnClick(R.id.comoayudar_url)
    public void comoayudar_url(){
        openLink("http://comoayudar.mx/");
    }

    @OnClick(R.id.text_comoayudar_url)
    public void text_comoayudar_url(){
        openLink("http://comoayudar.mx/");
    }

    @OnClick(R.id.amzn_url)
    public void amzn_url(){
        openLink("http://amzn.to/2yq5N8y");
    }

    @OnClick(R.id.text_amzn_url)
    public void text_amzn_url(){
        openLink("http://amzn.to/2yq5N8y");
    }


    public void openLink(String url){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}
