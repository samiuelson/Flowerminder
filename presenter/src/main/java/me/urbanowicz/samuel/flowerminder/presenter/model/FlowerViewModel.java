package me.urbanowicz.samuel.flowerminder.presenter.model;

import me.urbanowicz.samuel.flowerminder.domain.entity.FlowerEntity;

public class FlowerViewModel extends FlowerEntity {

    private String name;
    private long plannedDate;
    private int color;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public long getPlannedDate() {
        return plannedDate;
    }

    @Override
    public void setPlannedDate(long plannedDate) {
        this.plannedDate = plannedDate;
    }

    @Override
    public int getColor() {
        return color;
    }

    @Override
    public void setColor(int color) {
        this.color = color;
    }
}
