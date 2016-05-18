package me.urbanowicz.samuel.flowerminder.data.store;

import me.urbanowicz.samuel.flowerminder.data.Flower;

public class FlowersRepository implements DataStore.MultipleEntities<Flower> {

    private DataStore.MultipleEntities<Flower> inMemoryCache;

    private static FlowersRepository INSTANCE;

    private FlowersRepository(DataStore.MultipleEntities<Flower> inMemoryDataStore) {
        this.inMemoryCache = inMemoryDataStore;
    }

    public static synchronized FlowersRepository getInstance(DataStore.MultipleEntities<Flower> inMemoryCache) {
        if (INSTANCE == null) {
            INSTANCE = new FlowersRepository(inMemoryCache);
        }
        return INSTANCE;
    }

    @Override
    public void save(Flower entity) {
        inMemoryCache.save(entity);
    }

    @Override
    public void delete(Flower entity) {
        inMemoryCache.delete(entity);
    }

    @Override
    public Iterable<Flower> getAll() {
        return inMemoryCache.getAll();
    }

}
