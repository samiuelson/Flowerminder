package me.urbanowicz.samuel.flowerminder.flowers;

import android.os.Handler;

import me.urbanowicz.samuel.flowerminder.data.Flower;
import me.urbanowicz.samuel.flowerminder.data.store.FlowersRepository;

public class FlowersPresenter implements FlowersContract.Presenter {

    private FlowersContract.View flowersView;
    private FlowersRepository flowersRepository;

    public FlowersPresenter(FlowersContract.View view, FlowersRepository flowersRepository) {
        this.flowersView = view;
        this.flowersView.setPresenter(this);
        this.flowersRepository = flowersRepository;
    }

    @Override
    public void loadTasks() {
        Handler handler = new Handler();
        handler.post(() -> flowersView.displayLoadingIndicator(true));

        if (flowersRepository.getAll().iterator().hasNext()) {
            flowersView.displayFlowers(flowersRepository.getAll());
        } else {
            flowersView.displayNoFlowersInfo();
        }

        handler.postDelayed(() -> flowersView.displayLoadingIndicator(false), 5000);
    }

    @Override
    public void confirmFlowerHanding(Flower flower) {

    }

    @Override
    public void actionConfigure() {
        flowersView.showToast("Not implemented");
    }

    @Override
    public void actionInfo() {
        flowersView.showToast("Not implemented");
    }

    @Override
    public void actionRefresh() {
        // todo re-generate flowers with future dates
        Handler handler = new Handler();
        handler.post(() -> flowersView.displayLoadingIndicator(true));
        handler.postDelayed(() -> flowersView.displayLoadingIndicator(false), 5000);
    }

    @Override
    public void start() {
        loadTasks();
    }
}
