package me.urbanowicz.samuel.flowerminder.data;

import java.util.List;

public interface DataStore<Entity> {

    void saveEntities(List<Entity> entities);

    long saveEntity(Entity entity);

    void delete(Entity entity);

    List<Entity> getEntities();

}
