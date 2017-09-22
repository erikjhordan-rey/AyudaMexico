package io.github.erikcaffrey.ayudamexico.centers;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.OnClick;
import io.github.erikcaffrey.ayudamexico.R;
import io.github.erikcaffrey.ayudamexico.common.CoreFragment;

public class GatheringFragment extends CoreFragment {

    public static GatheringFragment newInstance() {
        return new GatheringFragment();
    }

    @BindView(R.id.list_centers)
    RecyclerView list;

    @Override protected int getLayoutResId() {
        return R.layout.gathering_fragment;
    }

    public void openLink(String url) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}
