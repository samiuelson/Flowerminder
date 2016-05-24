package me.urbanowicz.samuel.flowerminder;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public abstract class BaseToolbarActivity<F extends Fragment> extends AppCompatActivity {

    private F fragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.base_toolbar_activity);
        ((TextView) findViewById(R.id.toolbar_title)).setText(getToolbarTitle());
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(null);

        fragment = (F) getSupportFragmentManager().findFragmentById(R.id.container);

        if (fragment == null) {
            fragment = createNewFragmentInstance();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, fragment)
                    .commit();
        }
    }

    public @Nullable F getFragment() {
        return fragment;
    }

    public abstract String getToolbarTitle();

    public abstract F createNewFragmentInstance();

}
