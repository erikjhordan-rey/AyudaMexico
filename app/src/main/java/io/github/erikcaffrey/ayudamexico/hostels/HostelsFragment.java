package io.github.erikcaffrey.ayudamexico.hostels;

import io.github.erikcaffrey.ayudamexico.R;
import io.github.erikcaffrey.ayudamexico.common.CoreFragment;

public class HostelsFragment extends CoreFragment {

    public static HostelsFragment newInstance() {
        return new HostelsFragment();
    }

    @Override protected int getLayoutResId() {
        return R.layout.hostels_fragment;
    }
}
