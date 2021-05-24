package com.josegonzalez.musicsearchsample.view.itemList;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.josegonzalez.musicsearchsample.R;
import com.josegonzalez.musicsearchsample.model.TrackListDto;
import com.josegonzalez.musicsearchsample.presenter.ItemListPresenter;
import com.josegonzalez.musicsearchsample.view.BaseActivity;

import static com.josegonzalez.musicsearchsample.view.itemDetails.ItemDetailActivity.ARTIST_KEY;
import static com.josegonzalez.musicsearchsample.view.itemDetails.ItemDetailActivity.IMAGE_KEY;
import static com.josegonzalez.musicsearchsample.view.itemDetails.ItemDetailActivity.ITEM_DETAIL_DEEP_LINK;
import static com.josegonzalez.musicsearchsample.view.itemDetails.ItemDetailActivity.TRACK_KEY;

public class ItemListActivity extends BaseActivity implements ItemListView, CustomAdapter.TrackAdapterCallback {

    public static final String WORD_TO_SEARCH_KEY = "word";
    public static final String ITEM_LIST_DEEP_LINK = HOST + "itemList";

    private String wordToSearch;

    private TextView errorMessage;
    private Spinner spinner;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    private ItemListPresenter itemListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);
        itemListPresenter = new ItemListPresenter(this);
        init();
    }

    private void init() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());
        initRecyclerView();

        errorMessage = findViewById(R.id.error_message);
        spinner = findViewById(R.id.spinner);
        onLoading();
    }

    private void initRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        initItemList();
    }

    private void initItemList() {
        if (getIntent() != null && getIntent().getExtras() != null) {
            final Bundle extras = getIntent().getExtras();
            wordToSearch = extras.getString(WORD_TO_SEARCH_KEY);
            if (itemListPresenter != null) {
                itemListPresenter.searchWord(wordToSearch);
            }
        }
    }

    public void addTrackList(TrackListDto listDto) {
        recyclerView.setVisibility(View.VISIBLE);
        errorMessage.setVisibility(View.GONE);
        spinner.setVisibility(View.GONE);
        adapter = new CustomAdapter(listDto.getResults(), this);
        recyclerView.setAdapter(adapter);
    }

    public void onError() {
        recyclerView.setVisibility(View.GONE);
        errorMessage.setVisibility(View.VISIBLE);
        spinner.setVisibility(View.GONE);
    }

    public void onLoading() {
        recyclerView.setVisibility(View.GONE);
        errorMessage.setVisibility(View.GONE);
        spinner.setVisibility(View.VISIBLE);
    }

    @Override
    public void showDetails(String artistName, String trackName, String imageUrl) {
        final Bundle bundle = new Bundle();
        bundle.putString(ARTIST_KEY, artistName);
        bundle.putString(TRACK_KEY, trackName);
        bundle.putString(IMAGE_KEY, imageUrl);
        startActivityDeepLink(ITEM_DETAIL_DEEP_LINK, bundle);
    }

    @Override
    public void onListItemClicked(int position) {
        itemListPresenter.onItemSelected(position);
    }

}