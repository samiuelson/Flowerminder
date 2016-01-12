package me.urbanowicz.samuel.data;

import android.graphics.Color;

import com.raizlabs.android.dbflow.config.FlowManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import me.urbanowicz.samuel.flowerminder.data.FlowerDataSource;
import me.urbanowicz.samuel.flowerminder.domain.entity.FlowerEntity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, manifest = "src/main/AndroidManifest.xml")
public class EntityDataSourceTest {
    private FlowerDataSource flowerDataSource;

    @Before
    public void init() {
        FlowManager.init(RuntimeEnvironment.application.getApplicationContext());
        flowerDataSource = new FlowerDataSource();
    }

    @Test
    public void should_pass_dummy_test() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void should_store_flower() {
        FlowerEntity redRose = createRedRose();
        long id = flowerDataSource.saveEntity(redRose);
        redRose.setId(id);

        final FlowerEntity fetchedFlowerEntity = flowerDataSource.getEntities().get(0);
        assertEquals(redRose, fetchedFlowerEntity);
    }

    @Test
    public void should_store_flowers() {
        List<FlowerEntity> flowerEntitiesToBeStored = new ArrayList<>();
        flowerEntitiesToBeStored.add(createPinkTulip());
        flowerEntitiesToBeStored.add(createRedRose());
        flowerEntitiesToBeStored.add(createWhiteRose());
        flowerEntitiesToBeStored.add(createPinkTulip());

        flowerDataSource.saveEntities(flowerEntitiesToBeStored);

        flowerDataSource.getEntities().containsAll(flowerEntitiesToBeStored);
    }

    @Test
    public void should_delete_flower() {
        FlowerEntity redRose = createRedRose();
        long id = flowerDataSource.saveEntity(redRose);
        redRose.setId(id);

        List<FlowerEntity> storedFlowers = flowerDataSource.getEntities();
        assertTrue(storedFlowers.contains(redRose));

        flowerDataSource.delete(redRose);
        storedFlowers.clear();
        storedFlowers = flowerDataSource.getEntities();
        assertFalse(storedFlowers.contains(redRose));
    }

    private static FlowerEntity createRedRose() {
        return createFlowerEntity("Rose", Color.RED);
    }

    private static FlowerEntity createWhiteRose() {
        return createFlowerEntity("Rose", Color.WHITE);
    }

    private static FlowerEntity createPinkTulip() {
        return createFlowerEntity("Tulip", Color.MAGENTA);
    }

    private static FlowerEntity createFlowerEntity(String name, int color) {
        final Date plannedDate = new Date();
        FlowerEntity flowerEntity = new FlowerEntity();
        flowerEntity.setName(name);
        flowerEntity.setColor(color);
        flowerEntity.setPlannedDate(plannedDate.getTime());
        return flowerEntity;
    }
}