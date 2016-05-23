package me.urbanowicz.samuel.flowerminder.data.generator;

import com.google.common.collect.Lists;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import me.urbanowicz.samuel.flowerminder.data.Flower;
import me.urbanowicz.samuel.flowerminder.data.FlowerColor;
import me.urbanowicz.samuel.flowerminder.data.Girl;
import rx.Observable;

public class FlowerGenerator {
    private static final String TAG = FlowerGenerator.class.getSimpleName();
    private Girl girl;
    private List<Flower> flowers;

    public FlowerGenerator(Girl girl, Iterable<Flower> flowers) {
        this.girl = girl;
        this.flowers = Lists.newArrayList(flowers);
    }

    public Iterable<Flower> generateFlowersForNextMonth() {
        this.flowers = deleteAnyFutureFlowers(flowers);

        List<Date> datesForFlowers = generateDatesForFlowers();

        List<Flower> nextMonthFlowers = generateFlowersForDates(datesForFlowers);

        return nextMonthFlowers;
    }

    /*default*/ static List<Flower> deleteAnyFutureFlowers(List<Flower> flowers) {
        final List<Flower> flowersFromPast = Lists.newArrayList();

        Observable<Flower> flowersObservable = Observable.from(flowers);
        // look for Flowers with future dates
        flowersObservable
                .filter(flower -> flower.getDate().compareTo(new Date()) < 0)
                .toList().subscribe(filteredFlowers -> flowersFromPast.addAll(filteredFlowers));

        return flowersFromPast;
    }

    private List<Date> generateDatesForFlowers() {

        int desiredFlowersPerMonth = girl.getDesiredFlowersPerMonth();
        List<Date> importantDates =
                Lists.newArrayList(girl.getImportantAnniversariesDates().values());

        if (desiredFlowersPerMonth <= importantDates.size()) {
            return importantDates;
        }

        Date now = new Date();
        Date monthAfter = new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(30));

        List<Date> flowersDates = Lists.newArrayList();
        final Random random = new Random();
        for (int i = desiredFlowersPerMonth; i --> 0;) {
            int dayOfMonth = random.nextInt(30 + 1);
            Date potentialNewDate = new Date(now.getTime() + TimeUnit.DAYS.toMillis(dayOfMonth));

            while (flowersDates.contains(potentialNewDate)) {
                dayOfMonth = random.nextInt(30 + 1);
                potentialNewDate = new Date(now.getTime() + TimeUnit.DAYS.toMillis(dayOfMonth));
            }

            flowersDates.add(potentialNewDate);
        }

        return flowersDates;
    }

    private static List<Flower> generateFlowersForDates(List<Date> dates) {
        List<Flower> flowers = Lists.newArrayList();
        final int flowerColorsCount = FlowerColor.values().length;
        final Random random = new Random();

        for (Date date : dates) {
            int colorId = random.nextInt(flowerColorsCount);
            FlowerColor color = FlowerColor.values()[colorId];
            flowers.add(new Flower(color, date));
        }

        return flowers;
    }
}
