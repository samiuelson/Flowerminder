package me.urbanowicz.samuel.flowerminder.info;

import me.urbanowicz.samuel.flowerminder.BasePresenter;
import me.urbanowicz.samuel.flowerminder.BaseView;

public interface InfoContract {

    interface View extends BaseView<Presenter> {
        void showInfoView();
    }

    interface Presenter extends BasePresenter {

    }

}
