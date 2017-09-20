package io.github.erikcaffrey.ayudamexico.donations;

import io.github.erikcaffrey.ayudamexico.R;
import io.github.erikcaffrey.ayudamexico.common.CoreFragment;

public class DonationsFragment extends CoreFragment {

    public static DonationsFragment newInstance() {
        return new DonationsFragment();
    }

    @Override protected int getLayoutResId() {
        return R.layout.donations_fragment;
    }
}
