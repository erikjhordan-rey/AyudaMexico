package io.github.erikcaffrey.ayudamexico.phones;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.BindView;
import io.github.erikcaffrey.ayudamexico.R;
import io.github.erikcaffrey.ayudamexico.common.CoreFragment;

public abstract class PhonesFragment extends CoreFragment {

    @BindView(R.id.list_phones)
    RecyclerView listPhones;

    PhonesAdapter adapter;

    @Override protected int getLayoutResId() {
        return R.layout.phones_fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listPhones.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new PhonesAdapter();
        listPhones.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.setItems(getPhones());
    }

    abstract ArrayList<Phone> getPhones();
}
