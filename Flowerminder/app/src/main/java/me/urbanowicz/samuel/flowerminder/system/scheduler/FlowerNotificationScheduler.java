package me.urbanowicz.samuel.flowerminder.system.scheduler;

import me.urbanowicz.samuel.flowerminder.data.Flower;

public interface FlowerNotificationScheduler {

    void scheduleNotificationForFlower(Flower flower);

    void cancelNotificationForFlower(Flower flower);

    void cancellAllNotificationsForFlowers();

}
