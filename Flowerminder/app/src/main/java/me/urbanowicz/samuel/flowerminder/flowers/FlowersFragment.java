package me.urbanowicz.samuel.flowerminder.flowers;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import me.urbanowicz.samuel.flowerminder.R;
import me.urbanowicz.samuel.flowerminder.data.Flower;

public class FlowersFragment extends Fragment implements FlowersContract.View {

    private FlowersContract.Presenter presenter;
    private View noItemsView;
    private FlowersRecyclerAdapter adapter;
    private View progressView;
    private RecyclerView recycler;

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
        progressView = view.findViewById(R.id.progress);
        recycler = (RecyclerView) view.findViewById(R.id.flowers_recycler);
        recycler.setLayoutManager(new LinearLayoutManager(view.getContext()));
        adapter = new FlowersRecyclerAdapter();

        setHasOptionsMenu(true);
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
        recycler.setAdapter(adapter);
    }

    @Override
    public void displayLoadingIndicator(boolean active) {
        progressView.setVisibility(active? View.VISIBLE : View.INVISIBLE);
    }

    @Override
    public void displayNoFlowersInfo() {
        noItemsView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showToast(String string) {
        Toast.makeText(getActivity(), string, Toast.LENGTH_LONG).show();
    }

    @Override
    public void setPresenter(FlowersContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.flowers_fragment_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.config:
                presenter.actionConfigure();
                return true;
            case R.id.info:
                presenter.actionInfo();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
