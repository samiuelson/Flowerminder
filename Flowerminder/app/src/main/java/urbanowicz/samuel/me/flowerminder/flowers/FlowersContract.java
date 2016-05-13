package urbanowicz.samuel.me.flowerminder.flowers;

import urbanowicz.samuel.me.flowerminder.BasePresenter;
import urbanowicz.samuel.me.flowerminder.BaseView;
import urbanowicz.samuel.me.flowerminder.data.Flower;

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
