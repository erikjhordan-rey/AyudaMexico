package io.github.erikcaffrey.ayudamexico.announcement;

import io.github.erikcaffrey.ayudamexico.R;
import io.github.erikcaffrey.ayudamexico.common.CoreFragment;

public class AnnouncementFragment extends CoreFragment {

    public static AnnouncementFragment newInstance() {
        return new AnnouncementFragment();
    }

    @Override protected int getLayoutResId() {
        return R.layout.announcement_fragment;
    }
}
