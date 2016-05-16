package me.urbanowicz.samuel.flowerminder.flowers;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import me.urbanowicz.samuel.flowerminder.R;
import me.urbanowicz.samuel.flowerminder.data.Flower;

public class FlowersRecyclerAdapter extends RecyclerView.Adapter<FlowersRecyclerAdapter.FlowerViewHolder> {
    public FlowersRecyclerAdapter() {
        flowers = new ArrayList<>();
    }

    private List<Flower> flowers;

    void setFlowers(Iterable<Flower> flowers) {
        this.flowers.clear();
        for (Flower flower : flowers) {
            this.flowers.add(flower);
        }
    }

    @Override
    public FlowerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FlowerViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.flower_list_item, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(FlowerViewHolder holder, int position) {
        Flower flower = flowers.get(position);
        holder.flower.setColorFilter(flower.getColor());
        holder.date.setText(flower.getDate().toString());
    }

    @Override
    public int getItemCount() {
        return flowers.size();
    }

    //protected
    static class FlowerViewHolder extends RecyclerView.ViewHolder {
        final ImageView flower;
        final TextView date;
        public FlowerViewHolder(View itemView) {
            super(itemView);
            this.flower = (ImageView) itemView.findViewById(R.id.flower_img);
            this.date = (TextView) itemView.findViewById(R.id.date);
        }

    }
}
