package me.urbanowicz.samuel.flowerminder.data.generator;

import com.google.common.collect.Lists;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Date;
import java.util.List;

import me.urbanowicz.samuel.flowerminder.data.Flower;
import me.urbanowicz.samuel.flowerminder.data.Girl;
import me.urbanowicz.samuel.flowerminder.data.Mocks;
import me.urbanowicz.samuel.flowerminder.data.store.FlowersRepository;
import rx.Observable;

import static me.urbanowicz.samuel.flowerminder.data.Mocks.generateRandomFlowerForFutureDate;
import static me.urbanowicz.samuel.flowerminder.data.Mocks.generateRandomFlowerForPastDate;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class FlowerGeneratorTest {

    FlowerGenerator flowerGenerator;

    Girl girl;

    @Mock
    FlowersRepository flowersRepository;

    @Before
    public void
    setupBeforeTest() {
        MockitoAnnotations.initMocks(this);

        Mockito.when(flowersRepository.getAll()).thenReturn(
                Lists.newArrayList(
                        Mocks.generateRandomFlowerForPastDate(),
                        Mocks.generateRandomFlowerForPastDate(),
                        Mocks.generateRandomFlowerForPastDate())
        );

        girl = Mocks.generateGirl();
        flowerGenerator = new FlowerGenerator(girl, flowersRepository.getAll());
    }

    @Test
    public void
    deleteAnyFutureFlowers_shouldDeleteAnyFutureFlowers() {
        // Given list of flowers: one with future date, one with past date
        List<Flower> flowers = Lists.newArrayList(
                generateRandomFlowerForPastDate(),
                generateRandomFlowerForFutureDate()
        );

        // When deleteAnyFutureFlowers called
        List<Flower> flowersFromPast = FlowerGenerator.deleteAnyFutureFlowers(flowers);

        // Then no more flowers with future dates should remain
        Observable.from(flowersFromPast)
                .filter(flower -> flower.getDate().compareTo(new Date()) > 0)
                .count()
                .subscribe(integer -> {
                    assertTrue(integer == 0);
                });
    }

    @Test
    public void
    generateFlowersForNextMonth_shouldGenerateFlowersWithFutureDates() {
        // Given collection of flowers
        List<Flower> flowers = Lists.newArrayList(flowersRepository.getAll());
        assertNotNull(flowers);

        // When generate FlowersForNextMonth called
        flowers = Lists.newArrayList(flowerGenerator.generateFlowersForNextMonth());
        assertNotNull(flowers);

        // Then it should return proper number of flowers
        assertTrue(flowers.size() > 0);
        // All with future dates
        Date date = new Date();
        for (Flower flower : flowers) {
            assertTrue(flower.getDate().compareTo(date) > 0);
        }
    }

}