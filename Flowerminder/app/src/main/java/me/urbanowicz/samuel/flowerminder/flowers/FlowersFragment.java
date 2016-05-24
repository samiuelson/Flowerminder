package me.urbanowicz.samuel.flowerminder.flowers;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import me.urbanowicz.samuel.flowerminder.R;
import me.urbanowicz.samuel.flowerminder.data.Flower;
import me.urbanowicz.samuel.flowerminder.girl.GirlActivity;
import me.urbanowicz.samuel.flowerminder.info.InfoActivity;

import static com.google.common.base.Preconditions.checkNotNull;

public class FlowersFragment extends Fragment implements FlowersContract.View {

    private FlowersContract.Presenter presenter;
    private View noItemsView;
    private FlowersRecyclerAdapter adapter;
    private RecyclerView recycler;
    private SwipeRefreshLayout swipeRefreshLayout;

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

        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setOnRefreshListener(() -> presenter.actionRefresh());
        swipeRefreshLayout.setColorSchemeResources(
                R.color.colorAccent2,
                R.color.colorAccent,
                R.color.colorPrimary
        );

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
        swipeRefreshLayout.setRefreshing(active);
    }

    @Override
    public void displayNoFlowersInfo() {
        noItemsView.setVisibility(View.VISIBLE);
    }

    @Override
    public void displayGirlSetupView() {
        startActivity(new Intent(getActivity(), GirlActivity.class));
        getActivity().overridePendingTransition(0, 0);
    }

    @Override
    public void displayInfoView() {
        startActivity(new Intent(getActivity(), InfoActivity.class));
        getActivity().overridePendingTransition(0, 0);
    }

    @Override
    public void showToast(String string) {
        Toast.makeText(getActivity(), string, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showNoGirlWarning() {
        checkNotNull(getView());
        Snackbar snackbar = Snackbar.make(getView(),
                "You haven't set up details about your loved one yet.",
                Snackbar.LENGTH_INDEFINITE);
                snackbar.setAction("Set up",
                        v -> { displayGirlSetupView(); snackbar.dismiss(); })
                .show();
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
