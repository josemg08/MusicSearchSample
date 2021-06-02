package com.josegonzalez.musicsearchsample.features.search

class SearchPresenter(private val searchView: SearchView) {

    fun onSearch(wordToSearch: String?) {
        searchView.goToMusicList(wordToSearch)
    }

}