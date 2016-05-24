package me.urbanowicz.samuel.flowerminder.girl;

import android.os.Bundle;
import android.support.annotation.Nullable;

import me.urbanowicz.samuel.flowerminder.BaseToolbarActivity;

public class GirlActivity extends BaseToolbarActivity<GirlFragment> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new GirlPresenter(getFragment());
    }

    @Override
    public String getToolbarTitle() {
        return "Config";
    }

    @Override
    public GirlFragment createNewFragmentInstance() {
        return GirlFragment.newInstance();
    }

    @Override
    public boolean showBackButton() {
        return true;
    }
}
