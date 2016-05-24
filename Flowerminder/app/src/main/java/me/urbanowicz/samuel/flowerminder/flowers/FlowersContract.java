package me.urbanowicz.samuel.flowerminder.flowers;

import me.urbanowicz.samuel.flowerminder.BasePresenter;
import me.urbanowicz.samuel.flowerminder.BaseView;
import me.urbanowicz.samuel.flowerminder.data.Flower;

public interface FlowersContract {

    interface Presenter extends BasePresenter {
        void loadTasks();

        void confirmFlowerHanding(Flower flower);

        void actionConfigure();

        void actionInfo();

        void actionRefresh();
    }

    interface View extends BaseView<Presenter> {
        void displayFlowers(Iterable<Flower> flowers);

        void displayLoadingIndicator(boolean active);

        void displayNoFlowersInfo();

        void displayGirlSetupView();

        void displayInfoView();

        void showToast(String string);

        void showNoGirlWarning();
    }
}
