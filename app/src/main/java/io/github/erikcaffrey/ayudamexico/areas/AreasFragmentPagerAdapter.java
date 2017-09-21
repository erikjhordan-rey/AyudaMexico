package io.github.erikcaffrey.ayudamexico.areas;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

class AreasFragmentPagerAdapter extends FragmentStatePagerAdapter {

    private final int PAGE_COUNT = 3;

    AreasFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override public int getCount() {
        return PAGE_COUNT;
    }

    @Override public Fragment getItem(int position) {
        final Fragment fragments[] =
            new Fragment[] { CdmxMapFragment.newInstance(), PueblaMapFragment.newInstance(), MorelosMapFragment.newInstance() };
        return fragments[position];
    }

    @Override public CharSequence getPageTitle(int position) {
        final String tabTitles[] = new String[] { "CDMX", "Puebla", "Morelos" };
        return tabTitles[position];
    }
}

