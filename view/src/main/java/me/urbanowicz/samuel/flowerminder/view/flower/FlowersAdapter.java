package me.urbanowicz.samuel.flowerminder.view.flower;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import me.urbanowicz.samuel.flowerminder.R;
import me.urbanowicz.samuel.flowerminder.presenter.model.FlowerViewModel;

public class FlowersAdapter extends RecyclerView.Adapter<FlowersAdapter.FlowerViewHolder> {

    ArrayList<FlowerViewModel> flowers = new ArrayList<>();

    @Override
    public FlowerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FlowerViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.flowers_recycler_item, parent, false));
    }

    @Override
    public void onBindViewHolder(FlowerViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class FlowerViewHolder extends RecyclerView.ViewHolder {

        public FlowerViewHolder(View itemView) {
            super(itemView);
        }
    }
}
