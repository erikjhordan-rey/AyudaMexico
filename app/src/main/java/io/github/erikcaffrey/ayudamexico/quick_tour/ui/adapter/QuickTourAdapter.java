package io.github.erikcaffrey.ayudamexico.quick_tour.ui.adapter;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import io.github.erikcaffrey.ayudamexico.quick_tour.ui.QuickTourFragment;

/**
 * Created by diegofranco on 9/21/17.
 */

public class QuickTourAdapter extends FragmentPagerAdapter
{

    public QuickTourAdapter(FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int position)
    {
        switch (position)
        {
            case 0: return QuickTourFragment.newInstance(Color.parseColor("#006847"), position);
            case 1: return QuickTourFragment.newInstance(Color.parseColor("#FFFFFF"), position);
            case 2: return QuickTourFragment.newInstance(Color.parseColor("#CE1126"), position);
            case 3: return QuickTourFragment.newInstance(Color.parseColor("#006847"), position);
            default: return QuickTourFragment.newInstance(Color.parseColor("#006847"), position);
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
