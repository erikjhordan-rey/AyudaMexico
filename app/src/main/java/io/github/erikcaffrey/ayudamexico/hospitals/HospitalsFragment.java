package io.github.erikcaffrey.ayudamexico.hospitals;

import io.github.erikcaffrey.ayudamexico.R;
import io.github.erikcaffrey.ayudamexico.common.CoreFragment;

public class HospitalsFragment extends CoreFragment {

    public static HospitalsFragment newInstance() {
        return new HospitalsFragment();
    }

    @Override protected int getLayoutResId() {
        return R.layout.hospitals_fragment;
    }
}
