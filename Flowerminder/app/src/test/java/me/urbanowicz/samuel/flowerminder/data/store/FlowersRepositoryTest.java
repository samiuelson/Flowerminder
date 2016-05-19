package me.urbanowicz.samuel.flowerminder.data.store;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import me.urbanowicz.samuel.flowerminder.data.Flower;
import me.urbanowicz.samuel.flowerminder.data.Mocks;

import static org.mockito.Mockito.verify;

public class FlowersRepositoryTest {

    FlowersRepository flowersRepository;

    @Mock
    DataStore.MultipleEntities<Flower> flowersStorage;

    @Before
    public void
    setupForTest() {
        MockitoAnnotations.initMocks(this);
        flowersRepository = FlowersRepository.getInstance(flowersStorage);
    }

    @After
    public void
    cleanupAfterTest() {
        FlowersRepository.destroyInstance();
    }

    @Test
    public void
    save_savesFlowerToFlowersStorage() {
        // Given Flower object
        final Flower flower = Mocks.generateRandomFlower();

        // When flower is saved into repository
        flowersRepository.save(flower);

        // Then storage repository is called
        verify(flowersStorage).save(flower);
    }

    @Test
    public void
    delete_deletesFlowerFromFlowersStorage() {
        // Given Flower object
        final Flower flower = Mocks.generateRandomFlower();

        // When flower is deleted from repository
        flowersRepository.delete(flower);

        // Then storage repository is called
        verify(flowersStorage).delete(flower);
    }

    @Test
    public void
    getAll_fetchesFlowersFromFlowersStorage() {
        // Given Flowers repository
        // When repository is queried for a Flowers
        flowersRepository.getAll();

        // Then storage repository is called
        verify(flowersStorage).getAll();
    }
}
