package io.github.erikcaffrey.ayudamexico.common;

import butterknife.ButterKnife;
import erikjhordanrey.base_components.view.BaseActivity;

public class CoreActivity extends BaseActivity {

    @Override protected int getLayoutResId() {
        return 0;
    }

    @Override protected void initActivity() {
        super.initActivity();
        ButterKnife.bind(this);
    }
}
