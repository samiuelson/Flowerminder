package me.urbanowicz.samuel.flowerminder.flowers;

import me.urbanowicz.samuel.flowerminder.data.Flower;
import me.urbanowicz.samuel.flowerminder.data.store.FlowersRepository;

public class FlowersPresenter implements FlowersContract.Presenter {

    private FlowersContract.View flowersView;
    private FlowersRepository flowersRepository;

    public FlowersPresenter(FlowersContract.View view, FlowersRepository flowersRepository) {
        this.flowersView = view;
        flowersView.setPresenter(this);
        this.flowersRepository = flowersRepository;
    }

    @Override
    public void loadTasks() {
        flowersView.displayLoadingIndicator(true);
        if (flowersRepository.getAll().iterator().hasNext()) {
            flowersView.displayFlowers(flowersRepository.getAll());
        } else {
            flowersView.displayNoFlowersInfo();
        }
        flowersView.displayLoadingIndicator(false);
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
    public void start() {
        loadTasks();
    }
}
