package me.urbanowicz.samuel.flowerminder.data.store;

import me.urbanowicz.samuel.flowerminder.data.Girl;

public class GirlRepository implements DataStore.SingleEntity<Girl> {

    private DataStore.SingleEntity<Girl> girlStorage;

    private static GirlRepository INSTANCE;

    private GirlRepository(DataStore.SingleEntity<Girl> girlStorage) {
        this.girlStorage = girlStorage;
    }

    public static synchronized GirlRepository getInstance(DataStore.SingleEntity<Girl> girlStorage) {
        if (INSTANCE == null) {
            INSTANCE = new GirlRepository(girlStorage);
        }

        return INSTANCE;
    }

    public static synchronized void destroyInstance() {
        INSTANCE = null;
    }

    @Override
    public void save(Girl entity) {
        girlStorage.save(entity);
    }

    @Override
    public void delete(Girl entity) {
        girlStorage.delete(entity);
    }

    @Override
    public Girl get() {
        return girlStorage.get();
    }

}
