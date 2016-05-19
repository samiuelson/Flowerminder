package me.urbanowicz.samuel.flowerminder;


import me.urbanowicz.samuel.flowerminder.data.store.FakeFlowersInMemoryCache;
import me.urbanowicz.samuel.flowerminder.data.store.FakeGirlInMemoryStorage;
import me.urbanowicz.samuel.flowerminder.data.store.FlowersRepository;
import me.urbanowicz.samuel.flowerminder.data.store.GirlRepository;

public class Injection {
    public static FlowersRepository getFlowersRepository() {
        return FlowersRepository.getInstance(new FakeFlowersInMemoryCache());
    }

    public static GirlRepository getGirlRepository() {
        return GirlRepository.getInstance(new FakeGirlInMemoryStorage());
    }
}
