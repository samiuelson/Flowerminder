package me.urbanowicz.samuel.flowerminder.data.store;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;

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
    public void save(@NonNull Flower entity) {
        flowersStorage.save(entity);
    }

    @Override
    public void delete(@NonNull Flower entity) {
        flowersStorage.delete(entity);
    }

    @Override
    public @Nullable Iterable<Flower> getAll() {
        List<Flower> flowers = Lists.newArrayList(flowersStorage.getAll());
        Collections.sort(flowers);
        Collections.reverse(flowers);
        return flowers;
    }
}
