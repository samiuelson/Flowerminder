package me.urbanowicz.samuel.flowerminder.data.store;

import android.support.annotation.Nullable;

public interface DataStore {

    /**
     * Interface defining functionality of repository for multiple entities
     * @param <E> class of entity to be stored
     */
    interface MultipleEntities<E> {
        void save(@Nullable E entity);
        void delete(@Nullable E entity);
        @Nullable Iterable<E> getAll();
    }

    /**
     * Interface defining functionality of repository for single entity
     * @param <E> class of entity to be stored
     */
    interface SingleEntity<E> {
        void save(@Nullable E entity);
        void delete(@Nullable E entity);
        @Nullable E get();
    }

}
