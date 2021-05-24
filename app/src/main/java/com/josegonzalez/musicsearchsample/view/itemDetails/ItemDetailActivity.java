package com.josegonzalez.musicsearchsample.view.itemDetails;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;

import com.josegonzalez.musicsearchsample.R;
import com.josegonzalez.musicsearchsample.view.BaseActivity;

public class ItemDetailActivity extends BaseActivity {

    public static final String ARTIST_KEY = "artist";
    public static final String TRACK_KEY = "track";
    public static final String IMAGE_KEY = "image";
    public static final String ITEM_DETAIL_DEEP_LINK = HOST + "itemDetail";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        Toolbar toolbar = findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);

        if (savedInstanceState == null) {
            Bundle arguments = new Bundle();
            arguments.putString(ARTIST_KEY, getIntent().getStringExtra(ARTIST_KEY));
            arguments.putString(TRACK_KEY, getIntent().getStringExtra(TRACK_KEY));
            arguments.putString(IMAGE_KEY, getIntent().getStringExtra(IMAGE_KEY));
            ItemDetailFragment fragment = new ItemDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.item_detail_container, fragment)
                    .commit();
        }
    }

}