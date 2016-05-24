package me.urbanowicz.samuel.flowerminder.info;

import android.os.Bundle;
import android.support.annotation.Nullable;

import me.urbanowicz.samuel.flowerminder.BaseToolbarActivity;

public class InfoActivity extends BaseToolbarActivity<InfoFragment> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new InfoPresenter(getFragment());
    }

    @Override
    public String getToolbarTitle() {
        return "Info";
    }

    @Override
    public InfoFragment createNewFragmentInstance() {
        return InfoFragment.newInstance();
    }
}
