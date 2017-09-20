package io.github.erikcaffrey.ayudamexico.phones;

import io.github.erikcaffrey.ayudamexico.R;
import io.github.erikcaffrey.ayudamexico.common.CoreFragment;

public class PhonesFragment extends CoreFragment {

    public static PhonesFragment newInstance() {
        return new PhonesFragment();
    }

    @Override protected int getLayoutResId() {
        return R.layout.phones_fragment;
    }
}
