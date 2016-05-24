package me.urbanowicz.samuel.flowerminder.data.store;

import android.support.annotation.Nullable;

import me.urbanowicz.samuel.flowerminder.data.Girl;

public class GirlInMemoryCache implements DataStore.SingleEntity<Girl> {

    private Girl girl;

    public GirlInMemoryCache() {
    }

    @Override
    public void save(@Nullable Girl entity) {
        this.girl = entity;
    }

    @Override
    public void delete(@Nullable Girl entity) {

    }

    @Override
    public @Nullable Girl get() {
        return girl;
    }
}
