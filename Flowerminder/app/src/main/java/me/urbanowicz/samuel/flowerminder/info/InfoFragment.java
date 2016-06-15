package me.urbanowicz.samuel.flowerminder.info;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.urbanowicz.samuel.flowerminder.R;

public class InfoFragment extends Fragment implements InfoContract.View {

    public static InfoFragment newInstance() {
        return new InfoFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.info_fragment, container, false);
    }

    @Override
    public void showInfoView() {

    }

    @Override
    public void goToGooglePlay() {

    }

    @Override
    public void goToGitHub() {

    }

    @Override
    public void setPresenter(InfoContract.Presenter presenter) {

    }
}
