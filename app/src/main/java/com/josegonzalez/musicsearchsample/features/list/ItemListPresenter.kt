package com.josegonzalez.musicsearchsample.features.list

import com.josegonzalez.musicsearchsample.model.TrackDto
import com.josegonzalez.musicsearchsample.model.TrackListDto
import com.josegonzalez.musicsearchsample.repository.ItunesAPI
import com.josegonzalez.musicsearchsample.repository.ItunesClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ItemListPresenter(private val itemListView: ItemListView) {

    private val api: ItunesAPI = ItunesAPI()
    private val client: ItunesClient
    private var listDto: TrackListDto? = null
    private var itemList: List<TrackDto>? = null

    fun searchWord(word: String?) {
        client.getListOfSongsWithNumberOfElements(word, 20)?.enqueue(object : Callback<TrackListDto?> {
            override fun onResponse(call: Call<TrackListDto?>, response: Response<TrackListDto?>) {
                listDto = response.body()
                if (listDto!!.resultCount == 0) {
                    itemListView.onError()
                } else {
                    itemList = listDto!!.results
                    itemListView.addTrackList(listDto)
                }
            }

            override fun onFailure(call: Call<TrackListDto?>, throwable: Throwable) {
                itemListView.onError()
            }
        })
    }

    fun onItemSelected(position: Int) {
        itemListView.showDetails(itemList!![position].artistName,
                itemList!![position].trackName,
                itemList!![position].artworkUrl100)
    }

    init {
        client = api.client
    }

}