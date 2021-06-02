package com.josegonzalez.musicsearchsample.features.search

interface SearchView {

    fun onSearchButtonPressed()

    fun goToMusicList(wordToSearch: String?)

}