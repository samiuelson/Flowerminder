package me.urbanowicz.samuel.flowerminder.info;

import me.urbanowicz.samuel.flowerminder.BasePresenter;
import me.urbanowicz.samuel.flowerminder.BaseView;

public interface InfoContract {

    interface View extends BaseView<Presenter> {

        void showInfoView();

        void goToGooglePlay();

        void goToGitHub();

    }

    interface Presenter extends BasePresenter {

        void goToGooglePlayPressed();

        void forkOnGitHubPressed();
    }

}
