package me.urbanowicz.samuel.flowerminder.data.generator;

import me.urbanowicz.samuel.flowerminder.data.Flower;
import me.urbanowicz.samuel.flowerminder.data.Girl;

public class FlowerGenerator {

    private Girl girl;
    private Iterable<Flower> flowers;

    public FlowerGenerator(Girl girl, Iterable<Flower> flowers) {
        this.girl = girl;
        this.flowers = flowers;
    }

    public Iterable<Flower> generateFlowersForNextMonth() {
        return null;
    }
}
