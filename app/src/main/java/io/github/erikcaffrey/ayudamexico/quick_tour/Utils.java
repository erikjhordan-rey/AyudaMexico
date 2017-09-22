package io.github.erikcaffrey.ayudamexico.quick_tour;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by diegofranco on 9/21/17.
 */

public class Utils
{
    public static final String LAUNCHED_QUICKTOUR_KEY = "Launched_QuickTour";

    private static SharedPreferences getMobileCheckDepositPref(Context context)
    {
        return context.getSharedPreferences(LAUNCHED_QUICKTOUR_KEY, Context.MODE_PRIVATE);
    }

    public static boolean displayQuickTour(Context context)
    {
        return getMobileCheckDepositPref(context).getBoolean(LAUNCHED_QUICKTOUR_KEY, true);
    }

    public static void setQuickTourLaunched(Context context, boolean showAgain)
    {
        SharedPreferences sharePref = getMobileCheckDepositPref(context);
        SharedPreferences.Editor editor = sharePref.edit();
        editor.putBoolean(LAUNCHED_QUICKTOUR_KEY, showAgain);
        editor.apply();
    }
}
