package com.josegonzalez.musicsearchsample.view.itemList;

import com.josegonzalez.musicsearchsample.model.TrackListDto;

public interface ItemListView {

    void addTrackList(TrackListDto listDto);

    void onError();

    void onLoading();

    void showDetails(String artistName, String trackName, String imageUrl);

}
