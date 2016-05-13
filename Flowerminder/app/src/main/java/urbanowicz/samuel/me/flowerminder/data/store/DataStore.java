package urbanowicz.samuel.me.flowerminder.data.store;

/**
 * Interface defining functionality of repository for entities
 *
 * @param <E> class of entity to be stored
 */
public interface DataStore<E> {
    void save(E entity);
    void delete(E entity);
    Iterable<E> getAll();
}
