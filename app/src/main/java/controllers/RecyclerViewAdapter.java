package controllers;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import team.gatech.edu.login.R;

import model.Shelter;

/**
 * recycler view
 */
public class RecyclerViewAdapter
        extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private final Shelter[] data;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        private Shelter shelter;

        /**
         * view holder
         * @param textView text view
         */
        ViewHolder(TextView textView) {
            super(textView);
            this.textView = textView;
        }

        /**
         * get shelter
         * @return shelter
         */
        public Shelter getShelter() {
            return shelter;
        }
    }

    /**
     * recycler view constructor
     * @param data data
     */
    RecyclerViewAdapter(Shelter[] data) {
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
