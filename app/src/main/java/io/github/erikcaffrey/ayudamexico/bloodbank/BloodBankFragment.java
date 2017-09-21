package io.github.erikcaffrey.ayudamexico.bloodbank;

import io.github.erikcaffrey.ayudamexico.R;
import io.github.erikcaffrey.ayudamexico.common.CoreFragment;

public class BloodBankFragment extends CoreFragment {

    public static BloodBankFragment newInstance() {
        return new BloodBankFragment();
    }

    @Override protected int getLayoutResId() {
        return R.layout.blood_bank_fragment;
    }
}
