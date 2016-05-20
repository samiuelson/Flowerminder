package me.urbanowicz.samuel.flowerminder.data;

import android.support.annotation.NonNull;

import java.util.Date;

public class Flower implements Comparable<Flower> {
    private FlowerColor color;
    private Date handingDate;

    public Flower(@NonNull FlowerColor flowerColor, @NonNull Date date) {
        this.color = flowerColor;
        this.handingDate = date;
    }

    public FlowerColor getColor() {
        return color;
    }

    public Date getDate() {
        return handingDate;
    }

    @Override
    public int compareTo(Flower another) {
        return this.handingDate.compareTo(another.handingDate);
    }
}
