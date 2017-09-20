package io.github.erikcaffrey.ayudamexico.internet;

import io.github.erikcaffrey.ayudamexico.R;
import io.github.erikcaffrey.ayudamexico.common.CoreFragment;

public class InternetFragment extends CoreFragment {

    public static InternetFragment newInstance() {
        return new InternetFragment();
    }

    @Override protected int getLayoutResId() {
        return R.layout.internet_fragment;
    }
}
