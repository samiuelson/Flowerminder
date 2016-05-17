package me.urbanowicz.samuel.flowerminder;

import me.urbanowicz.samuel.flowerminder.data.store.FlowersInMemoryCache;
import me.urbanowicz.samuel.flowerminder.data.store.FlowersRepository;

public class Injection {
    public static FlowersRepository getFlowersRepository() {
        FlowersInMemoryCache inMemoryCache = new FlowersInMemoryCache();
        return FlowersRepository.getInstance(inMemoryCache);
    }
}
