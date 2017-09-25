package io.github.erikcaffrey.ayudamexico.centers.main.view;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;

import io.github.erikcaffrey.ayudamexico.centers.gathering.ui.GatheringFragment;
import io.github.erikcaffrey.ayudamexico.centers.puebla.view.PueblaCollectorFragment;

/**
 * Created by Armando on 24/9/2017.
 */

public class CentersMainFragmentPagerAdapter extends FragmentPagerAdapter {
    private final Context context;
    private Fragment fragments[] = new Fragment[]{GatheringFragment.newInstance(),
            PueblaCollectorFragment.newInstance()};
    private String titles[] = new String[]{"Varios", "Puebla"};

    public CentersMainFragmentPagerAdapter(FragmentManager childFragmentManager, Context context) {
        super(childFragmentManager);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
