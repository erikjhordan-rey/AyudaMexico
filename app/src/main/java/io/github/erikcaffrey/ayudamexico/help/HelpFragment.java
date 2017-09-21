package io.github.erikcaffrey.ayudamexico.help;

import io.github.erikcaffrey.ayudamexico.R;
import io.github.erikcaffrey.ayudamexico.common.CoreFragment;

public class HelpFragment extends CoreFragment {

    public static HelpFragment newInstance() {
        return new HelpFragment();
    }

    @Override protected int getLayoutResId() {
        return R.layout.help_fragment;
    }
}
