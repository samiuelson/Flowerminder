package me.urbanowicz.samuel.flowerminder.flowers;

import android.os.Handler;

import java.util.Iterator;

import me.urbanowicz.samuel.flowerminder.data.Flower;
import me.urbanowicz.samuel.flowerminder.data.store.FlowersRepository;
import me.urbanowicz.samuel.flowerminder.data.store.GirlRepository;

import static com.google.common.base.Preconditions.checkNotNull;

public class FlowersPresenter implements FlowersContract.Presenter {

    private FlowersContract.View flowersView;
    private FlowersRepository flowersRepository;
    private final GirlRepository girlRepository;

    public FlowersPresenter(FlowersContract.View view,
                            FlowersRepository flowersRepository,
                            GirlRepository girlRepository) {
        this.flowersView = view;
        this.flowersView.setPresenter(this);
        this.flowersRepository = flowersRepository;
        this.girlRepository = girlRepository;
    }

    @Override
    public void loadTasks() {
        Handler handler = new Handler();
        handler.post(() -> flowersView.displayLoadingIndicator(true));

        Iterable<Flower> flowers = flowersRepository.getAll();
        checkNotNull(flowers);
        if (flowers.iterator().hasNext()) {
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
        flowersView.displayGirlSetupView();
    }

    @Override
    public void actionInfo() {
        flowersView.displayInfoView();
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
        if (girlRepository.get() == null) {
            flowersView.showNoGirlWarning();
        }
        loadTasks();
    }
}
