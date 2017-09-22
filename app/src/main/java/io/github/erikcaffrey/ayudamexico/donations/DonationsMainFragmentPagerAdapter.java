package io.github.erikcaffrey.ayudamexico.donations;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by armando on 9/22/17.
 */

public class DonationsMainFragmentPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 2;
    private final Context context;
    private String titles[] = new String[] {"¿Dónde donar?", "Donativos Conekta"};
    private Fragment fragments[] = new Fragment[] { DonationsFragment.newInstance(), DonationsConektaFragment.newInstance() };

    public DonationsMainFragmentPagerAdapter(FragmentManager childFragmentManager, Context context) {
        super(childFragmentManager);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
