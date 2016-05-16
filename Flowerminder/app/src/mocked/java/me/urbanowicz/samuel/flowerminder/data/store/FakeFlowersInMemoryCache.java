package me.urbanowicz.samuel.flowerminder.data.store;

import java.util.List;

import me.urbanowicz.samuel.flowerminder.data.Flower;

public class FakeFlowersInMemoryCache implements DataStore<Flower> {

    private List<Flower> flowers;

    static {
        // create & store dummy flowers here
    }

    @Override
    public void save(Flower entity) {

    }

    @Override
    public void delete(Flower entity) {

    }

    @Override
    public Iterable<Flower> getAll() {
        return null;
    }
}
