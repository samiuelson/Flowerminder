package me.urbanowicz.samuel.flowerminder.girl;

import android.support.v4.app.Fragment;

public class GirlFragment extends Fragment implements GirlContract.View {

    private GirlContract.Presenter presenter;

    public static GirlFragment newInstance() {
        return new GirlFragment();
    }

    @Override
    public void setPresenter(GirlContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
