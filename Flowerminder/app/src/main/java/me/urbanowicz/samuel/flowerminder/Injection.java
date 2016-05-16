package me.urbanowicz.samuel.flowerminder;

import me.urbanowicz.samuel.flowerminder.data.Flower;
import me.urbanowicz.samuel.flowerminder.data.store.DataStore;
import me.urbanowicz.samuel.flowerminder.data.store.FlowersRepository;

public class Injection {
    public static FlowersRepository getFlowersRepository(DataStore<Flower> inMemoryCache) {
        return FlowersRepository.getInstance(inMemoryCache);
    }
}
