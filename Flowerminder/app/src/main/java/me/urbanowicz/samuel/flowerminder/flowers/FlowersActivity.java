package me.urbanowicz.samuel.flowerminder.flowers;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import me.urbanowicz.samuel.flowerminder.BaseToolbarActivity;
import me.urbanowicz.samuel.flowerminder.Injection;
import me.urbanowicz.samuel.flowerminder.R;

public class FlowersActivity extends BaseToolbarActivity<FlowersFragment> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FlowersPresenter presenter = new FlowersPresenter(
                getFragment(),
                Injection.getFlowersRepository()
        );

    }

    @Override
    public String getToolbarTitle() {
        return "Flowers";
    }

    @Override
    public FlowersFragment createNewFragmentInstance() {
        return FlowersFragment.newInstance();
    }
}
