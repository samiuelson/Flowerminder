package urbanowicz.samuel.me.flowerminder;

import urbanowicz.samuel.me.flowerminder.data.Flower;
import urbanowicz.samuel.me.flowerminder.data.store.DataStore;
import urbanowicz.samuel.me.flowerminder.data.store.FlowersRepository;

public class Injection {
    public static FlowersRepository getFlowersRepository(DataStore<Flower> inMemoryCache) {
        return FlowersRepository.getInstance(inMemoryCache);
    }
}
