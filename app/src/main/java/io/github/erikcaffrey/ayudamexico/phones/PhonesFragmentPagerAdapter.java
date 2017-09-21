package io.github.erikcaffrey.ayudamexico.phones;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import io.github.erikcaffrey.ayudamexico.phones.PhonesFragment;

public class PhonesFragmentPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 4;
    private String tabTitles[] = new String[] { "CDMX", "Edo. México", "Puebla", "Morelos" };
    private Fragment fragments[] = new Fragment[] {new CdmxPhonesFragment(), new EdoPhonesFragment(), new PueblaPhonesFragment(), new MorelosPhonesFragment()};
    private Context context;

    public PhonesFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}

