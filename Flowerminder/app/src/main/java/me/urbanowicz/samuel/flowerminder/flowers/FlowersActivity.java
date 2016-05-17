package me.urbanowicz.samuel.flowerminder.flowers;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import me.urbanowicz.samuel.flowerminder.Injection;
import me.urbanowicz.samuel.flowerminder.R;

public class FlowersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.flowers_activity);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        setTitle(null);

        FlowersFragment flowersFragment =
                (FlowersFragment) getSupportFragmentManager().findFragmentById(R.id.container);

        if (flowersFragment == null) {
            flowersFragment = FlowersFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, flowersFragment)
                    .commit();
        }

        FlowersPresenter presenter = new FlowersPresenter(flowersFragment, Injection.getFlowersRepository());

    }
}
