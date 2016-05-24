package me.urbanowicz.samuel.flowerminder.data.store;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

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
    public void save(@NonNull Girl entity) {
        girlStorage.save(entity);
    }

    @Override
    public void delete(@NonNull Girl entity) {
        girlStorage.delete(entity);
    }

    @Override
    public @Nullable Girl get() {
        return girlStorage.get();
    }

}
