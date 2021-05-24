package com.josegonzalez.musicsearchsample.view.itemDetails;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.josegonzalez.musicsearchsample.R;

import static com.josegonzalez.musicsearchsample.view.itemDetails.ItemDetailActivity.ARTIST_KEY;
import static com.josegonzalez.musicsearchsample.view.itemDetails.ItemDetailActivity.IMAGE_KEY;
import static com.josegonzalez.musicsearchsample.view.itemDetails.ItemDetailActivity.TRACK_KEY;

public class ItemDetailFragment extends Fragment {

    private String artist;
    private String track;
    private String imageUrl;

    public ItemDetailFragment() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        if (getArguments().containsKey(ARTIST_KEY)) {
            artist = getArguments().getString(ARTIST_KEY);

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(artist);
            }
        }
        track = getArguments().getString(TRACK_KEY);
        imageUrl = getArguments().getString(IMAGE_KEY);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_detail, container, false);

        ImageView imageView = ((ImageView)rootView.findViewById(R.id.imageView));

        if (artist != null) {
            ((TextView) rootView.findViewById(R.id.artist_name)).setText(artist);
        }
        if (track != null) {
            ((TextView) rootView.findViewById(R.id.track_name)).setText(track);
        }

        if (imageUrl != null && !imageUrl.isEmpty()) {
            Glide.with(getContext())
                    .load(imageUrl)
                    .into(imageView);
        }

        return rootView;
    }

}