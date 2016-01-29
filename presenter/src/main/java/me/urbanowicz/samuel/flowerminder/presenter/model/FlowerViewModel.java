package me.urbanowicz.samuel.flowerminder.presenter.model;

import me.urbanowicz.samuel.flowerminder.domain.entity.FlowerEntity;

public class FlowerViewModel {
    String name;

    public FlowerViewModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static FlowerViewModel from(FlowerEntity flowerEntity) {
        return new FlowerViewModel(flowerEntity.getName());
    }
}
