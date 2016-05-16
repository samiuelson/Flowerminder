package urbanowicz.samuel.me.flowerminder.flowers;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import urbanowicz.samuel.me.flowerminder.R;

public class FlowersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.flowers_activity);

        FlowersFragment flowersFragment =
                (FlowersFragment) getSupportFragmentManager().findFragmentById(R.id.container);

        if (flowersFragment == null) {
            flowersFragment = FlowersFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, flowersFragment)
                    .commit();
        }

        FlowersPresenter presenter = new FlowersPresenter(flowersFragment);

    }
}
