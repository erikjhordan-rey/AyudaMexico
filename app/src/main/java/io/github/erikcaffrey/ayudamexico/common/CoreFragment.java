package io.github.erikcaffrey.ayudamexico.common;

import android.support.annotation.NonNull;
import android.view.View;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import erikjhordanrey.base_components.view.BaseFragment;

public class CoreFragment extends BaseFragment {

  private Unbinder unbinder;

  @Override protected int getLayoutResId() {
    return 0;
  }

  @Override protected void initFragment(@NonNull View view) {
    super.initFragment(view);
    unbinder = ButterKnife.bind(this, view);
  }

  @Override public void onDestroy() {
    super.onDestroy();
    unbinder.unbind();
  }
}