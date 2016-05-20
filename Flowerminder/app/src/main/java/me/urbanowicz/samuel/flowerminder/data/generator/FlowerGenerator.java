package me.urbanowicz.samuel.flowerminder.data.generator;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import me.urbanowicz.samuel.flowerminder.data.Flower;
import me.urbanowicz.samuel.flowerminder.data.Girl;
import rx.Observable;
import rx.Observer;

public class FlowerGenerator {
    private static final String TAG = FlowerGenerator.class.getSimpleName();
    private Girl girl;
    private List<Flower> flowers;

    public FlowerGenerator(Girl girl, Iterable<Flower> flowers) {
        this.girl = girl;
        this.flowers = Lists.newArrayList(flowers);
    }

    public Iterable<Flower> generateFlowersForNextMonth() {
        deleteAnyFutureFlowers(flowers);

        Iterable<Flower> nextMonthFlowers = new ArrayList<>();
        // todo generate next month flowers
        int desiredFlowersPerMonth = girl.getDesiredFlowersPerMonth();

        return nextMonthFlowers;
    }

    //default
    static List<Flower> deleteAnyFutureFlowers(List<Flower> flowers) {
        final List<Flower> flowersFromPast = Lists.newArrayList();

        Observable<Flower> flowersObservable = Observable.from(flowers);
        // look for Flowers with future dates
        flowersObservable
                .filter(flower -> flower.getDate().compareTo(new Date()) < 0)
                .toList()
                .subscribe(new Observer<List<Flower>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(List<Flower> flowers) {
                        flowersFromPast.addAll(flowers);

                    }
                });

        return flowersFromPast;
    }
}
