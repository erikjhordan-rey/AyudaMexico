package io.github.erikcaffrey.ayudamexico.splash;

import android.content.Intent;

import io.github.erikcaffrey.ayudamexico.R;
import io.github.erikcaffrey.ayudamexico.common.CoreActivity;
import io.github.erikcaffrey.ayudamexico.home.HomeActivity;
import io.github.erikcaffrey.ayudamexico.quick_tour.QuickTourActivity;
import io.github.erikcaffrey.ayudamexico.quick_tour.Utils;

/**
 * Created by diegofranco on 9/21/17.
 */

public class Splash extends CoreActivity
{

    private static final int TIME_DELAY = 250;

    @Override
    protected int getLayoutResId() {
        return R.layout.splash_empty_layout;
    }

    @Override
    protected void initActivity()
    {
        super.initActivity();
        if(Utils.displayQuickTour(Splash.this))
        {
            Intent intent = new Intent(Splash.this, QuickTourActivity.class);
            startActivity(intent);
        }
        else
        {
            Intent intent = new Intent(Splash.this, HomeActivity.class);
            startActivity(intent);
        }
        finish();
    }

    @Override
    public void finish() {
        super.finish();
    }
}
