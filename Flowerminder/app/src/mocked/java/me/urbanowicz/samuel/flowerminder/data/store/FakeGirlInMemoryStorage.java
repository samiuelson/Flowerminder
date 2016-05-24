package me.urbanowicz.samuel.flowerminder.data.store;

import me.urbanowicz.samuel.flowerminder.data.Girl;

public class FakeGirlInMemoryStorage implements DataStore.SingleEntity<Girl> {

    private Girl girl;

    public FakeGirlInMemoryStorage() {
        Girl.Builder builder = new Girl.Builder();
        builder.withName("Mia");
        builder.withDesiredFlowersPerMonth(3);
        builder.withEyesColor(0x6B442B);
        builder.withHairColor(0x382F29);
        this.girl = builder.build();
    }

    @Override
    public void save(Girl entity) {
        this.girl = entity;
    }

    @Override
    public void delete(Girl entity) {

    }

    @Override
    public Girl get() {
        return girl;
    }
}
