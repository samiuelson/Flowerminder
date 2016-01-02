package me.urbanowicz.samuel.data;

import android.graphics.Color;

import com.raizlabs.android.dbflow.config.FlowManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.util.Date;

import me.urbanowicz.samuel.flowerminder.data.FlowerDataSource;
import me.urbanowicz.samuel.flowerminder.domain.entity.FlowerEntity;

import static org.junit.Assert.assertEquals;

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
        final Date plannedDate = new Date();
        FlowerEntity flowerEntity = new FlowerEntity();
        flowerEntity.setName("Rose");
        flowerEntity.setColor(Color.RED);
        flowerEntity.setPlannedDate(plannedDate.getTime());

        flowerDataSource.saveEntity(flowerEntity);

        final FlowerEntity fetchedFlowerEntity = flowerDataSource.getEntities().get(0);
        assertEquals(flowerEntity, fetchedFlowerEntity);
    }
}