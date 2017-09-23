package io.github.erikcaffrey.ayudamexico.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class CustomViewPager extends ViewPager {

    private boolean enableScroll = false;

    public CustomViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override public boolean onTouchEvent(MotionEvent ev) {
        return enableScroll && super.onTouchEvent(ev);
    }

    @Override public boolean onInterceptTouchEvent(MotionEvent ev) {
        return enableScroll && super.onInterceptTouchEvent(ev);
    }
}