package me.urbanowicz.samuel.flowerminder;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import static com.google.common.base.Preconditions.checkNotNull;

public abstract class BaseToolbarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.base_toolbar_activity);
        TextView title = (TextView) findViewById(R.id.toolbar_title);
        checkNotNull(title);
        title.setText(getToolbarTitle());
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(null);

        if (showBackButton()) {
            ActionBar actionBar = getSupportActionBar();
            checkNotNull(actionBar);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public abstract String getToolbarTitle();

    public abstract boolean showBackButton();

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

}
