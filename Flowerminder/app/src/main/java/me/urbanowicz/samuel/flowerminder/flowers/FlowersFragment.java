package me.urbanowicz.samuel.flowerminder.flowers;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.urbanowicz.samuel.flowerminder.R;
import me.urbanowicz.samuel.flowerminder.data.Flower;

public class FlowersFragment extends Fragment implements FlowersContract.View {

    private FlowersContract.Presenter presenter;
    private View noItemsView;
    private FlowersRecyclerAdapter adapter;

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
        RecyclerView recycler = (RecyclerView) view.findViewById(R.id.flowers_recycler);
        adapter = new FlowersRecyclerAdapter();
        recycler.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.start();
    }

    @Override
    public void displayFlowers(Iterable<Flower> flowers) {
        noItemsView.setVisibility(View.GONE);
        adapter.setFlowers(flowers);
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
