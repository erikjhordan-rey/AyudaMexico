package io.github.erikcaffrey.ayudamexico.quick_tour.ui;

import android.support.v4.view.ViewPager;
import android.view.View;

import io.github.erikcaffrey.ayudamexico.R;

/**
 * Created by diegofranco on 9/21/17.
 */

public class QuickTourPageTransformer implements ViewPager.PageTransformer
{
    @Override
    public void transformPage(View page, float position)
    {

        int pageWidth = page.getWidth();
        float pageWidthTimesPosition = pageWidth * position;
        float absPosition = Math.abs(position);

        if (position <= -1.0f || position >= 1.0f)
        {

        }
        else if (position == 0.0f) {

        }

        else {

            View title = page.findViewById(R.id.title);
            title.setAlpha(1.0f - absPosition);


            View description = page.findViewById(R.id.description);
            description.setTranslationY(-pageWidthTimesPosition / 2f);
            description.setAlpha(1.0f - absPosition);

            View computer = page.findViewById(R.id.tv);

            if (computer != null) {
                computer.setAlpha(1.0f - absPosition);
                computer.setTranslationX(-pageWidthTimesPosition * 1.5f);
            }
        }
    }
}
