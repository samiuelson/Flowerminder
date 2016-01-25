package me.urbanowicz.samuel.flowerminder.view.flower;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.urbanowicz.samuel.flowerminder.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class FlowersListFragment extends Fragment {

    private RecyclerView flowersRecyclerView;

    public static FlowersListFragment newInstance() {

        Bundle args = new Bundle();

        FlowersListFragment fragment = new FlowersListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public FlowersListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        flowersRecyclerView = (RecyclerView) view.findViewById(R.id.flowersRecyclerView);


    }
}
