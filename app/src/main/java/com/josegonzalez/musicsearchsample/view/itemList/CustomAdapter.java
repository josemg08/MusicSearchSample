package com.josegonzalez.musicsearchsample.view.itemList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.josegonzalez.musicsearchsample.R;
import com.josegonzalez.musicsearchsample.model.TrackDto;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.TrackViewHolder> {

    private List<TrackDto> dataSet;
    private TrackAdapterCallback trackAdapterCallback;

    private Context context;

    public interface TrackAdapterCallback{
        void onListItemClicked(int position);
    }

    public static class TrackViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;
        TextView textViewVersion;
        ImageView imageViewIcon;

        public TrackViewHolder(View itemView) {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            this.textViewVersion = (TextView) itemView.findViewById(R.id.textViewVersion);
            this.imageViewIcon = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }

    public CustomAdapter(List<TrackDto> data, TrackAdapterCallback trackAdapterCallback) {
        this.dataSet = data;
        this.trackAdapterCallback = trackAdapterCallback;
    }

    @Override
    public TrackViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_layout, parent, false);
        context = parent.getContext();
        TrackViewHolder myViewHolder = new TrackViewHolder(view);
        myViewHolder.itemView.setOnClickListener(v ->
                trackAdapterCallback.onListItemClicked(myViewHolder.getAdapterPosition()));
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final TrackViewHolder holder, final int listPosition) {
        TextView textViewName = holder.textViewName;
        TextView textViewVersion = holder.textViewVersion;
        ImageView imageView = holder.imageViewIcon;

        textViewName.setText(dataSet.get(listPosition).getTrackName());
        textViewVersion.setText(dataSet.get(listPosition).getArtistName());

        if (dataSet.get(listPosition).getArtworkUrl100() != null && !dataSet.get(listPosition).getArtworkUrl100().isEmpty()) {
            Glide.with(context)
                    .load(dataSet.get(listPosition).getArtworkUrl100())
                    .into(imageView);
        }
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

}
