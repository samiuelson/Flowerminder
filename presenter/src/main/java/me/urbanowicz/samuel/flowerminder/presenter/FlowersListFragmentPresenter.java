package me.urbanowicz.samuel.flowerminder.presenter;

import java.util.ArrayList;
import java.util.List;

import me.urbanowicz.samuel.flowerminder.data.FlowerDataStore;
import me.urbanowicz.samuel.flowerminder.domain.entity.FlowerEntity;
import me.urbanowicz.samuel.flowerminder.presenter.model.FlowerViewModel;

public class FlowersListFragmentPresenter {

    private FlowersListOperations flowersListUI;
    private FlowerDataStore flowerDataStore;


    public FlowersListFragmentPresenter(FlowersListOperations flowersListUI) {
        this.flowersListUI = flowersListUI;
        this.flowerDataStore = new FlowerDataStore();

        flowersListUI.onLoadFlowers(fetchFlowersFromDb());
    }

    private List<FlowerViewModel> fetchFlowersFromDb() {
        List<FlowerViewModel> flowerViewModels = new ArrayList<>();
        for (FlowerEntity flowerEntity : flowerDataStore.getEntities()) {
            flowerViewModels.add(FlowerViewModel.from(flowerEntity));
        }
        return flowerViewModels;
    }
    
    public void onAddDummyFlowerClicked() {
        FlowerEntity flowerEntity = new FlowerEntity();
        flowerEntity.setName("Dummy Rose");
        flowerDataStore.saveEntity(flowerEntity);
        flowersListUI.onLoadFlowers(fetchFlowersFromDb());
    }


    public interface FlowersListOperations {
        void onLoadFlowers(List<FlowerViewModel> flowers);
    }
}
