package me.urbanowicz.samuel.flowerminder.info;

import android.os.Bundle;
import android.support.annotation.Nullable;

import me.urbanowicz.samuel.flowerminder.BaseToolbarActivity;
import me.urbanowicz.samuel.flowerminder.R;

public class InfoActivity extends BaseToolbarActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        InfoFragment fragment =
                (InfoFragment) getSupportFragmentManager().findFragmentByTag("info_fragment");

        if (fragment == null) {
            fragment = InfoFragment.newInstance();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, fragment, "info_fragment")
                    .commit();
        }

        new InfoPresenter(fragment);
    }

    @Override
    public String getToolbarTitle() {
        return "Info";
    }

    @Override
    public boolean showBackButton() {
        return true;
    }
}
