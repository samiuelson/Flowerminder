package urbanowicz.samuel.me.flowerminder.flowers;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import urbanowicz.samuel.me.flowerminder.R;
import urbanowicz.samuel.me.flowerminder.data.Flower;

public class FlowersFragment extends Fragment implements FlowersContract.View {

    private FlowersContract.Presenter presenter;
    private View noItemsView;

    public static FlowersFragment newInstance() {
        return new FlowersFragment();
    }

    @Nullable
    @Override
    public View onCreateView(
            LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.flowers_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        noItemsView = view.findViewById(R.id.no_items_view);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.start();
    }

    @Override
    public void displayFlowers(Iterable<Flower> flowers) {
        noItemsView.setVisibility(View.GONE);
    }

    @Override
    public void displayLoadingIndicator(boolean active) {

    }

    @Override
    public void displayNoFlowersInfo() {
        noItemsView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setPresenter(FlowersContract.Presenter presenter) {
        this.presenter = presenter;
    }

}
