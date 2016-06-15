package me.urbanowicz.samuel.flowerminder.girl;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

public class GirlFragment extends Fragment implements GirlContract.View {

    private GirlContract.Presenter presenter;

    public static GirlFragment newInstance() {
        return new GirlFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public void setPresenter(GirlContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
