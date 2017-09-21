package io.github.erikcaffrey.ayudamexico.faqs;

import io.github.erikcaffrey.ayudamexico.R;
import io.github.erikcaffrey.ayudamexico.common.CoreFragment;

public class QuestionsFragment extends CoreFragment {

    public static QuestionsFragment newInstance() {
        return new QuestionsFragment();
    }

    @Override protected int getLayoutResId() {
        return R.layout.questions_fragment;
    }
}
