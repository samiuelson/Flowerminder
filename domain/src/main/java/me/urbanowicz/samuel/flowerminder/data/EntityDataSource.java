package me.urbanowicz.samuel.flowerminder.data;

import java.util.List;

public interface EntityDataSource<Entity> {
    void saveEntities(List<Entity> entities);
    void saveEntity(Entity entity);
    List<Entity> getEntities();
}
