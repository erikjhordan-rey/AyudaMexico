package io.github.erikcaffrey.ayudamexico.phones;

import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import butterknife.BindView;
import io.github.erikcaffrey.ayudamexico.R;
import io.github.erikcaffrey.ayudamexico.common.CoreFragment;

public class PhoneListsFragment extends CoreFragment {

    @BindView(R.id.viewpager) ViewPager viewPager;

    @BindView(R.id.tabs) TabLayout tabs;

    public static PhoneListsFragment newInstance() {
        return new PhoneListsFragment();
    }

    @Override protected int getLayoutResId() {
        return R.layout.fragment_phone_lists;
    }

    @Override protected void initFragment(@NonNull View view) {
        super.initFragment(view);
        viewPager.setAdapter(new PhonesFragmentPagerAdapter(getActivitySupportFragmentManager(), getContext()));
        tabs.setupWithViewPager(viewPager);
    }
}
