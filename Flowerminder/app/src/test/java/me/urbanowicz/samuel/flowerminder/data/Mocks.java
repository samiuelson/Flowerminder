package me.urbanowicz.samuel.flowerminder.data;

import java.util.Date;
import java.util.Random;

public class Mocks {
    public static Flower generateRandomFlower() {
        int rand = Math.abs(new Random().nextInt());
        int colorId = rand % FlowerColor.values().length;
        return new Flower(FlowerColor.values()[colorId], new Date());
    }

    public static Girl generateGirl() {
        Girl.Builder builder = new Girl.Builder();
        builder.withName("Mia");
        builder.withDesiredFlowersPerMonth(3);
        builder.withEyesColor(0x6B442B);
        builder.withHairColor(0x382F29);
        return builder.build();
    }
}
