package io.github.erikcaffrey.ayudamexico.centers.main.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import butterknife.BindView;
import erikjhordanrey.base_components.view.BaseFragment;
import io.github.erikcaffrey.ayudamexico.R;
import io.github.erikcaffrey.ayudamexico.common.CoreFragment;

/**
 * Created by Armando on 24/9/2017.
 */

public class CentersMainFragment extends CoreFragment {

    @BindView(R.id.centers_options_viewpager)
    ViewPager viewPager;

    @BindView(R.id.centers_options_tabs)
    TabLayout tabs;

    public static CentersMainFragment newInstance() {return new CentersMainFragment();}


    @Override
    protected int getLayoutResId() {
        return R.layout.centers_main_fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager.setAdapter(new CentersMainFragmentPagerAdapter(getChildFragmentManager(), getContext()));
        tabs.setupWithViewPager(viewPager);
    }
}
