package io.github.erikcaffrey.ayudamexico.phones;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import butterknife.BindView;
import io.github.erikcaffrey.ayudamexico.R;
import io.github.erikcaffrey.ayudamexico.common.CoreFragment;

public abstract class PhonesFragment extends CoreFragment {

    @BindView(R.id.list_phones_mexico_city)
    RecyclerView listPhones;

    @Override protected int getLayoutResId() {
        return R.layout.phones_fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listPhones.setLayoutManager(new LinearLayoutManager(getContext()));
        PhonesAdapter adapter = new PhonesAdapter();
        adapter.setItems(getPhones());
        listPhones.setAdapter(adapter);
    }

    abstract ArrayList<Phone> getPhones();
}
