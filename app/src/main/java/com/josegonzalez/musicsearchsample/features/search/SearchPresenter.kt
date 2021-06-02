package com.josegonzalez.musicsearchsample.features.search

class SearchPresenter(private val searchView: SearchView) {

    fun onSearch(wordToSear5ch: String?) {
        searchView.goToMusicList(wordToSear5ch)
    }

}