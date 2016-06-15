package me.urbanowicz.samuel.flowerminder.info;

public class InfoPresenter implements InfoContract.Presenter {

    private final InfoContract.View infoView;

    public InfoPresenter(InfoContract.View view) {
        this.infoView = view;
    }

    @Override
    public void start() {
        infoView.setPresenter(this);
        infoView.showInfoView();
    }

    @Override
    public void goToGooglePlayPressed() {
        infoView.goToGooglePlay();
    }

    @Override
    public void forkOnGitHubPressed() {
        infoView.goToGitHub();
    }
}
