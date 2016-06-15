package me.urbanowicz.samuel.flowerminder.girl;

import android.os.Bundle;
import android.support.annotation.Nullable;

import me.urbanowicz.samuel.flowerminder.BaseToolbarActivity;
import me.urbanowicz.samuel.flowerminder.R;

public class GirlActivity extends BaseToolbarActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        GirlFragment fragment =
                (GirlFragment) getSupportFragmentManager().findFragmentByTag("girl_fragment");

        if (fragment == null) {
            fragment = GirlFragment.newInstance();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, fragment, "girl_fragment")
                    .commit();
        }

        new GirlPresenter(fragment);
    }

    @Override
    public String getToolbarTitle() {
        return "Config";
    }

    @Override
    public boolean showBackButton() {
        return true;
    }
}
