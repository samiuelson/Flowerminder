package me.urbanowicz.samuel.flowerminder.system.scheduler;

import java.util.Date;

public interface FlowersGeneratorScheduler {

    void scheduleNextFlowersGeneration(Date date);

    void cancelNextFlowersGeneration(Date date);

    void cancellAllFlowersGenerations();
}
