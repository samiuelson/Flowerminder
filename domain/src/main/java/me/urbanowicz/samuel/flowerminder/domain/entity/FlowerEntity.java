package me.urbanowicz.samuel.flowerminder.domain.entity;

import java.util.Objects;

public class FlowerEntity extends BaseEntity {

    private String name;
    private int color;
    private long plannedDate;
    private Girl girl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public long getPlannedDate() {
        return plannedDate;
    }

    public void setPlannedDate(long plannedDate) {
        this.plannedDate = plannedDate;
    }

    public Girl getGirl() {
        return girl;
    }

    public void setGirl(Girl girl) {
        this.girl = girl;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        FlowerEntity otherFlower = (FlowerEntity) obj;

        return getName().equals(otherFlower.getName())
                & getColor() == otherFlower.getColor()
                & getPlannedDate() == otherFlower.getPlannedDate()
                & Objects.equals(getGirl(), otherFlower.getGirl());

        // TODO: 02.01.2016 consider comparing other fields
    }
}
