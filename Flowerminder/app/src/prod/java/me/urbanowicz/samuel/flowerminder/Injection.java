package me.urbanowicz.samuel.flowerminder;

import me.urbanowicz.samuel.flowerminder.data.store.FlowersInMemoryCache;
import me.urbanowicz.samuel.flowerminder.data.store.FlowersRepository;
import me.urbanowicz.samuel.flowerminder.data.store.GirlInMemoryCache;
import me.urbanowicz.samuel.flowerminder.data.store.GirlRepository;

public class Injection {
    public static FlowersRepository getFlowersRepository() {
        FlowersInMemoryCache inMemoryCache = new FlowersInMemoryCache();
        return FlowersRepository.getInstance(inMemoryCache);
    }

    public static GirlRepository getGirlRepository() {
        GirlInMemoryCache girlInMemoryStorage = new GirlInMemoryCache();
        return GirlRepository.getInstance(girlInMemoryStorage);
    }
}
