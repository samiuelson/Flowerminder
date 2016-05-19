package me.urbanowicz.samuel.flowerminder.data.store;

import me.urbanowicz.samuel.flowerminder.data.Flower;

public class FlowersRepository implements DataStore.MultipleEntities<Flower> {

    private DataStore.MultipleEntities<Flower> flowersStorage;

    private static FlowersRepository INSTANCE;

    private FlowersRepository(DataStore.MultipleEntities<Flower> inMemoryDataStore) {
        this.flowersStorage = inMemoryDataStore;
    }

    public static synchronized FlowersRepository getInstance(DataStore.MultipleEntities<Flower> inMemoryCache) {
        if (INSTANCE == null) {
            INSTANCE = new FlowersRepository(inMemoryCache);
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    @Override
    public void save(Flower entity) {
        flowersStorage.save(entity);
    }

    @Override
    public void delete(Flower entity) {
        flowersStorage.delete(entity);
    }

    @Override
    public Iterable<Flower> getAll() {
        return flowersStorage.getAll();
    }
}
