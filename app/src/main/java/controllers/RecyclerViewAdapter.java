package controllers;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import team.gatech.edu.login.R;

import model.Shelter;


public class RecyclerViewAdapter
        extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private final Shelter[] data;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView textView;
        public Shelter shelter;

        public ViewHolder(TextView textView) {
            super(textView);
            this.textView = textView;
        }

// --Commented out by Inspection START (2018-04-15 오후 11:46):
//        public Shelter getShelter() {
//            return shelter;
//        }
// --Commented out by Inspection STOP (2018-04-15 오후 11:46)
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
