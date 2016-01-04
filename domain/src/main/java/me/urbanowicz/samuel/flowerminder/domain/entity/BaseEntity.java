package me.urbanowicz.samuel.flowerminder.domain.entity;

public class BaseEntity {
    private long id = -1;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
