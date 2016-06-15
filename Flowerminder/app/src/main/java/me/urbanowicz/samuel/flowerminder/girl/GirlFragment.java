package me.urbanowicz.samuel.flowerminder.girl;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.urbanowicz.samuel.flowerminder.R;

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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.girl_fragment, container, false);
    }

    @Override
    public void setPresenter(GirlContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
