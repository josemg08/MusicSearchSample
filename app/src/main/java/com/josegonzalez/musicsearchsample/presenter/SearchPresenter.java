package com.josegonzalez.musicsearchsample.presenter;

import com.josegonzalez.musicsearchsample.view.search.SearchView;

public class SearchPresenter {

    private SearchView searchView;

    public SearchPresenter (SearchView searchView) {
        this.searchView = searchView;
    }

    public void onSearch(String wordToSear5ch) {
        searchView.goToMusicList(wordToSear5ch);
    }

}
