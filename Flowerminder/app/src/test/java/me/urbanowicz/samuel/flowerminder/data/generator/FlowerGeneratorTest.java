package me.urbanowicz.samuel.flowerminder.data.generator;

import com.google.common.collect.Lists;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import me.urbanowicz.samuel.flowerminder.data.Flower;
import me.urbanowicz.samuel.flowerminder.data.Girl;
import me.urbanowicz.samuel.flowerminder.data.Mocks;
import me.urbanowicz.samuel.flowerminder.data.store.FlowersRepository;

import static org.junit.Assert.assertNotNull;

public class FlowerGeneratorTest {

    FlowerGenerator flowerGenerator;

    @Mock
    Girl girl;

    @Mock
    FlowersRepository flowersRepository;


    @Before
    public void
    setupBeforeTest() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(flowersRepository.getAll()).thenReturn(Lists.newArrayList(
                Mocks.generateRandomFlower(),
                Mocks.generateRandomFlower(),
                Mocks.generateRandomFlower()
                )
        );

        Mockito.when(girl).thenReturn(Mocks.generateGirl());
        flowerGenerator = new FlowerGenerator(girl, flowersRepository.getAll());
    }

    @Test
    public void
    generateFlowersForNextMonth_shouldGenerateProperFlowers() {
        Iterable<Flower> flowers = flowerGenerator.generateFlowersForNextMonth();

        assertNotNull("Flowers are null", flowers);
    }


}