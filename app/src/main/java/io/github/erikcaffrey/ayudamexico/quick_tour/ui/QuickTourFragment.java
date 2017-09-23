package io.github.erikcaffrey.ayudamexico.quick_tour.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import io.github.erikcaffrey.ayudamexico.R;
import io.github.erikcaffrey.ayudamexico.common.CoreFragment;

/**
 * Created by diegofranco on 9/21/17.
 */

public class QuickTourFragment extends CoreFragment {

    @BindView(R.id.intro_background) View background;

    int layoutResId;

    @Override protected int getLayoutResId() {
        return layoutResId;
    }

    @Override protected void initFragment(@NonNull View view) {
        super.initFragment(view);
    }

    @Override public void onDestroy() {
        super.onDestroy();
    }

    private static final String BACKGROUND_COLOR = "backgroundColor";
    private static final String PAGE = "page";

    private int mBackgroundColor, mPage;

    public static QuickTourFragment newInstance(int backgroundColor, int page) {
        QuickTourFragment frag = new QuickTourFragment();
        Bundle b = new Bundle();
        b.putInt(BACKGROUND_COLOR, backgroundColor);
        b.putInt(PAGE, page);
        frag.setArguments(b);
        return frag;
    }

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!getArguments().containsKey(BACKGROUND_COLOR)) {
            throw new RuntimeException("Fragment must contain a \"" + BACKGROUND_COLOR + "\" argument!");
        }
        mBackgroundColor = getArguments().getInt(BACKGROUND_COLOR);

        if (!getArguments().containsKey(PAGE)) throw new RuntimeException("Fragment must contain a \"" + PAGE + "\" argument!");
        mPage = getArguments().getInt(PAGE);
    }

    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        switch (mPage) {
            case 0:
                layoutResId = R.layout.quick_tour_layout_1;
                break;

            case 1:
                layoutResId = R.layout.quick_tour_layout_2;
                break;

            case 2:
                layoutResId = R.layout.quick_tour_layout_3;
                break;

            case 3:
                layoutResId = R.layout.quick_tour_layout_4;
                break;
        }

        // Inflate the layout resource file
        View view = getActivity().getLayoutInflater().inflate(layoutResId, container, false);

        // Set the current page index as the View's tag (useful in the PageTransformer)
        view.setTag(mPage);

        return view;
    }

    @Override public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        background.setBackgroundColor(mBackgroundColor);
    }
}
