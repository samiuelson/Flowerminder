package me.urbanowicz.samuel.flowerminder.girl;

public class GirlPresenter implements GirlContract.Presenter {
    private GirlContract.View girlView;

    public GirlPresenter(GirlContract.View girlView) {
        this.girlView = girlView;
    }

    @Override
    public void start() {

    }
}
