package me.urbanowicz.samuel.flowerminder.flowers;

import me.urbanowicz.samuel.flowerminder.BasePresenter;
import me.urbanowicz.samuel.flowerminder.BaseView;
import me.urbanowicz.samuel.flowerminder.data.Flower;

public interface FlowersContract {

    interface Presenter extends BasePresenter {
        void loadTasks();
        void confirmFlowerHanding(Flower flower);
    }

    interface View extends BaseView<Presenter> {
        void displayFlowers(Iterable<Flower> flowers);
        void displayLoadingIndicator(boolean active);
        void displayNoFlowersInfo();
    }
}
