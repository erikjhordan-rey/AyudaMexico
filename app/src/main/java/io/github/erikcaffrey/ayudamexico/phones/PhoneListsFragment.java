package io.github.erikcaffrey.ayudamexico.phones;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import butterknife.BindView;
import io.github.erikcaffrey.ayudamexico.R;
import io.github.erikcaffrey.ayudamexico.common.CoreFragment;

public class PhoneListsFragment extends CoreFragment{

    @BindView(R.id.viewpager)
    ViewPager viewPager;

    @BindView(R.id.tabs)
    TabLayout tabs;

    public static PhoneListsFragment newInstance() {
        return new PhoneListsFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_phone_lists;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager.setAdapter(new PhonesFragmentPagerAdapter(getChildFragmentManager(), getContext()));
        tabs.setupWithViewPager(viewPager);
    }
}
