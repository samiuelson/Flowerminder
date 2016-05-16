package me.urbanowicz.samuel.flowerminder;


import me.urbanowicz.samuel.flowerminder.data.store.FakeFlowersInMemoryCache;
import me.urbanowicz.samuel.flowerminder.data.store.FlowersRepository;

public class Injection {
    public static FlowersRepository getFlowersRepository() {
        FakeFlowersInMemoryCache inMemoryCache = new FakeFlowersInMemoryCache();
        return FlowersRepository.getInstance(inMemoryCache);
    }
}
