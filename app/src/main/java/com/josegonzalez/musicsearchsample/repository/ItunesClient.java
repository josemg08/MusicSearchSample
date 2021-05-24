package com.josegonzalez.musicsearchsample.repository;

import com.josegonzalez.musicsearchsample.model.TrackListDto;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ItunesClient {

    @GET("/lookup")
    Call<TrackListDto> getListOfSongsByArtistId(@Query("id") long id);

    @GET("/search?mediaType=music&")
    Call<TrackListDto> getListOfSongsWithNumberOfElements(@Query("term") String searchTerm, @Query("limit") int numberOfSongsInList);

    @GET("/search?mediaType=music&entity=song&limit=20&")
    Call<TrackListDto> getListOfSongsByAlbum(@Query("id") long id);

}