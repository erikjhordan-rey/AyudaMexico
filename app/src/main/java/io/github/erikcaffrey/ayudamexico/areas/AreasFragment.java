package io.github.erikcaffrey.ayudamexico.areas;

import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import butterknife.BindView;
import io.github.erikcaffrey.ayudamexico.R;
import io.github.erikcaffrey.ayudamexico.common.CoreFragment;

public class AreasFragment extends CoreFragment {

    @BindView(R.id.viewpager_maps) ViewPager viewPager;

    @BindView(R.id.tabs_maps) TabLayout tabs;

    public static AreasFragment newInstance() {
        return new AreasFragment();
    }

    @Override protected int getLayoutResId() {
        return R.layout.fragment_area;
    }

    @Override protected void initFragment(@NonNull View view) {
        super.initFragment(view);
        viewPager.setAdapter(new AreasFragmentPagerAdapter(getActivitySupportFragmentManager()));
        tabs.setupWithViewPager(viewPager);
    }

    @Override public void onDestroy() {
        if (viewPager != null) {
            viewPager.removeAllViews();
        }
        super.onDestroy();
    }
}
