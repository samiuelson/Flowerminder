package me.urbanowicz.samuel.flowerminder;

import me.urbanowicz.samuel.flowerminder.data.Flower;
import me.urbanowicz.samuel.flowerminder.data.store.DataStore;

public class Injection {
    public static FlowersRepository getFlowersRepository() {
        FlowersInMemoryCache inMemoryCache = new FlowersInMemoryCache();
        return FlowersRepository.getInstance(inMemoryCache);
    }
}
