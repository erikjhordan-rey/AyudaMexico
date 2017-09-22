package io.github.erikcaffrey.ayudamexico.quick_tour;

import android.support.v4.view.ViewPager;

import butterknife.BindView;
import io.github.erikcaffrey.ayudamexico.R;
import io.github.erikcaffrey.ayudamexico.common.CoreActivity;
import io.github.erikcaffrey.ayudamexico.quick_tour.ui.QuickTourPageTransformer;
import io.github.erikcaffrey.ayudamexico.quick_tour.ui.adapter.QuickTourAdapter;

/**
 * Created by diegofranco on 9/21/17.
 */

public class QuickTourActivity extends CoreActivity
{
    @BindView(R.id.quick_tour_viewpager) ViewPager mViewPager;

    @Override
    protected int getLayoutResId()
    {
        return R.layout.quick_tour_activity;
    }

    @Override
    protected void initActivity()
    {
        super.initActivity();
        mViewPager.setAdapter(new QuickTourAdapter(getSupportFragmentManager()));
        mViewPager.setPageTransformer(false, new QuickTourPageTransformer());
    }
}
