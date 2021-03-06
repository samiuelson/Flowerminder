package me.urbanowicz.samuel.flowerminder.data.store;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import me.urbanowicz.samuel.flowerminder.data.Flower;
import me.urbanowicz.samuel.flowerminder.data.FlowerColor;

public class FakeFlowersInMemoryCache implements DataStore.MultipleEntities<Flower> {

    private static List<Flower> flowers = new ArrayList<>();

    static {
        // create & store dummy flowers here
        for (int i = 100; i --> 0;) {
            Date date = new Date(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(i));
            Flower flower = new Flower(FlowerColor.values() [i % FlowerColor.values().length], date);
            flowers.add(flower);
        }

        // generate upcomming flower

    }

    @Override
    public void save(Flower entity) {

    }

    @Override
    public void delete(Flower entity) {

    }

    @Override
    public Iterable<Flower> getAll() {
        return flowers;
    }
}
