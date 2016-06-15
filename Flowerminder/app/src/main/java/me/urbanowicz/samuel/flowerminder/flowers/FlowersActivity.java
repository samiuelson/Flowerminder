package me.urbanowicz.samuel.flowerminder.flowers;

import android.os.Bundle;
import android.support.annotation.Nullable;

import me.urbanowicz.samuel.flowerminder.BaseToolbarActivity;
import me.urbanowicz.samuel.flowerminder.Injection;
import me.urbanowicz.samuel.flowerminder.R;

public class FlowersActivity extends BaseToolbarActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FlowersFragment fragment =
                (FlowersFragment) getSupportFragmentManager().findFragmentByTag("flowers_fragment");

        if (fragment == null) {
            fragment = FlowersFragment.newInstance();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, fragment, "flowers_fragment")
                    .commit();
        }

        new FlowersPresenter(
                fragment,
                Injection.getFlowersRepository(),
                Injection.getGirlRepository()
        );

    }

    @Override
    public String getToolbarTitle() {
        return getString(R.string.flowers_toolbar_title);
    }

    @Override
    public boolean showBackButton() {
        return false;
    }

}
