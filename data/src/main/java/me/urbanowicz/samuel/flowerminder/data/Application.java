package me.urbanowicz.samuel.flowerminder.data;

import com.raizlabs.android.dbflow.config.FlowManager;

public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();

        FlowManager.init(this);
    }
}
