package Controllers;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import team.gatech.edu.login.R;

import Model.Shelter;

/**
 * Created by jpbronsted on 3/7/18.
 */

public class RecyclerViewAdapter
        extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private Shelter[] data;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public Shelter shelter;

        public ViewHolder(TextView textView) {
            super(textView);
            this.textView = textView;
        }

        public Shelter getShelter() {
            return shelter;
        }
    }

    public RecyclerViewAdapter(Shelter[] data) {
        this.data = data;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent, int viewType) {
        final TextView view = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_card_layout, parent, false);
        return new RecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(data[position].toString());
        holder.shelter = data[position];
    }

    @Override
    public int getItemCount() {
        return data.length;
    }
}
