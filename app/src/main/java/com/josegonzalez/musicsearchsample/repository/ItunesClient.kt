package com.josegonzalez.musicsearchsample.repository

import com.josegonzalez.musicsearchsample.model.TrackListDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ItunesClient {

    @GET("/lookup")
    fun getListOfSongsByArtistId(@Query("id") id: Long): Call<TrackListDto?>?

    @GET("/search?mediaType=music&")
    fun getListOfSongsWithNumberOfElements(@Query("term") searchTerm: String?, @Query("limit") numberOfSongsInList: Int): Call<TrackListDto?>?

    @GET("/search?mediaType=music&entity=song&limit=20&")
    fun getListOfSongsByAlbum(@Query("id") id: Long): Call<TrackListDto?>?

}