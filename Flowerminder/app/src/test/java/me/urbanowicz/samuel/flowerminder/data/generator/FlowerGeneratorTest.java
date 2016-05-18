package me.urbanowicz.samuel.flowerminder.data.generator;

import com.google.common.collect.Lists;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Date;
import java.util.Random;

import me.urbanowicz.samuel.flowerminder.data.Flower;
import me.urbanowicz.samuel.flowerminder.data.FlowerColor;
import me.urbanowicz.samuel.flowerminder.data.Girl;
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
                generateRandomFlower(),
                generateRandomFlower(),
                generateRandomFlower()
                )
        );

        Mockito.when(girl).thenReturn(generateGirl());
        flowerGenerator = new FlowerGenerator(girl, flowersRepository.getAll());
    }

    @Test
    public void
    shouldGenerateFlower() {
        Iterable<Flower> flowers = flowerGenerator.generateFlowersForNextMonth();

        assertNotNull("Flowers are null", flowers);
    }

    static Flower generateRandomFlower() {
        int rand = Math.abs(new Random().nextInt());
        int colorId = rand % FlowerColor.values().length;
        return new Flower(FlowerColor.values()[colorId], new Date());
    }

    static Girl generateGirl() {
        Girl.Builder builder = new Girl.Builder();
        builder.withName("Mia");
        builder.withDesiredFlowersPerMonth(3);
        builder.withEyesColor(0x6B442B);
        builder.withHairColor(0x382F29);
        return builder.build();
    }
}