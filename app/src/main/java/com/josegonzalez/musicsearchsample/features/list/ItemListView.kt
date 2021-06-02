package com.josegonzalez.musicsearchsample.features.list

import com.josegonzalez.musicsearchsample.model.TrackListDto

interface ItemListView {

    fun addTrackList(listDto: TrackListDto?)
    fun onError()
    fun onLoading()
    fun showDetails(artistName: String?, trackName: String?, imageUrl: String?)

}