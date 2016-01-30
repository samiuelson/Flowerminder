package me.urbanowicz.samuel.flowerminder.view.flower;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import me.urbanowicz.samuel.flowerminder.R;
import me.urbanowicz.samuel.flowerminder.presenter.model.FlowerViewModel;

public class FlowersAdapter extends RecyclerView.Adapter<FlowersAdapter.FlowerViewHolder> {

    private ArrayList<FlowerViewModel> flowers = new ArrayList<>();

    @Override
    public FlowerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FlowerViewHolder(
                LayoutInflater.
                from(parent.getContext())
                .inflate(R.layout.flowers_recycler_item, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(FlowerViewHolder holder, int position) {
        holder.flowerNameTextView.setText(flowers.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return flowers.size();
    }

    class FlowerViewHolder extends RecyclerView.ViewHolder {
        final TextView flowerNameTextView;

        public FlowerViewHolder(View itemView) {
            super(itemView);
            this.flowerNameTextView = (TextView) itemView.findViewById(R.id.flowerNameTextView);
        }
    }
}
