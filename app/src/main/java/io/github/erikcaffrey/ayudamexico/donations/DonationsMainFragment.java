package io.github.erikcaffrey.ayudamexico.donations;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import butterknife.BindView;
import io.github.erikcaffrey.ayudamexico.R;
import io.github.erikcaffrey.ayudamexico.common.CoreFragment;

/**
 * Created by armando on 9/22/17.
 */

public class DonationsMainFragment extends CoreFragment {

    @BindView(R.id.donation_options_viewpager)
    ViewPager viewPager;

    @BindView(R.id.donation_options_tabs)
    TabLayout tabs;

    public static DonationsMainFragment newInstance(){ return new DonationsMainFragment(); }

    @Override
    protected int getLayoutResId() {
        return R.layout.donations_main_fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager.setAdapter(new DonationsMainFragmentPagerAdapter(getChildFragmentManager(), getContext()));
        tabs.setupWithViewPager(viewPager);
    }
}
