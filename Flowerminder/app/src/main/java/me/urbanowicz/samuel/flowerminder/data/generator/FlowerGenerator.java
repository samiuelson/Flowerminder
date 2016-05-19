package me.urbanowicz.samuel.flowerminder.data.generator;

import android.util.Log;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import me.urbanowicz.samuel.flowerminder.data.Flower;
import me.urbanowicz.samuel.flowerminder.data.Girl;
import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;

public class FlowerGenerator {
    private static final String TAG = FlowerGenerator.class.getSimpleName();
    private Girl girl;
    private List<Flower> flowers;

    public FlowerGenerator(Girl girl, Iterable<Flower> flowers) {
        this.girl = girl;
        this.flowers = Lists.newArrayList(flowers);
    }

    public Iterable<Flower> generateFlowersForNextMonth() {
        Observable.from(flowers)
                .filter( // look for Flowers with future dates
                        flower -> flower.getDate().compareTo(new Date()) > 0
                )
                .subscribe(
                        flower -> flowers.remove(flower),
                        throwable -> Log.e(TAG, throwable.getMessage()),
                        new Action0() { //on finish
                            @Override
                            public void call() {

                            }
                        })
        ;

        Iterable<Flower> nextMonthFlowers = new ArrayList<>();
        // todo generate next month flowers
        return nextMonthFlowers;
    }
}
