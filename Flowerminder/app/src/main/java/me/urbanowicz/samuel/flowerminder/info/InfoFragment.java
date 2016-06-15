package me.urbanowicz.samuel.flowerminder.info;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
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
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        view.findViewById(R.id.rate_btn).setOnClickListener(v -> goToGooglePlay());
        view.findViewById(R.id.github_btn).setOnClickListener(v -> goToGitHub());
    }

    @Override
    public void goToGooglePlay() {
        final String packageName = getActivity().getPackageName();
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + packageName)));
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + packageName)));
        }
    }

    @Override
    public void goToGitHub() {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/samiuelson/flowerminder")));
    }

    @Override
    public void setPresenter(InfoContract.Presenter presenter) {

    }
}
