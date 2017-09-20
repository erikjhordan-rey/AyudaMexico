package io.github.erikcaffrey.ayudamexico.centers;

import io.github.erikcaffrey.ayudamexico.R;
import io.github.erikcaffrey.ayudamexico.common.CoreFragment;

public class GatheringFragment extends CoreFragment {

    public static GatheringFragment newInstance() {
        return new GatheringFragment();
    }

    @Override protected int getLayoutResId() {
        return R.layout.gathering_fragment;
    }
}
