package me.urbanowicz.samuel.flowerminder.data.store;

public interface DataStore {

    /**
     * Interface defining functionality of repository for multiple entities
     * @param <E> class of entity to be stored
     */
    interface MultipleEntities<E> {
        void save(E entity);
        void delete(E entity);
        Iterable<E> getAll();
    }

    /**
     * Interface defining functionality of repository for single entity
     * @param <E> class of entity to be stored
     */
    interface SingleEntity<E> {
        void save(E entity);
        void delete(E entity);
        E get();
    }

}
