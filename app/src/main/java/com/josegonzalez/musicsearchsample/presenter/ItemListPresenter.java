package com.josegonzalez.musicsearchsample.presenter;

import android.util.Log;

import androidx.annotation.NonNull;

import com.josegonzalez.musicsearchsample.model.TrackDto;
import com.josegonzalez.musicsearchsample.model.TrackListDto;
import com.josegonzalez.musicsearchsample.repository.ItunesAPI;
import com.josegonzalez.musicsearchsample.repository.ItunesClient;
import com.josegonzalez.musicsearchsample.view.itemList.ItemListView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemListPresenter {

    private ItemListView itemListView;

    private ItunesAPI api;
    private ItunesClient client;
    private TrackListDto listDto;

    private List<TrackDto> itemList;

    public ItemListPresenter (ItemListView itemListView) {
        this.itemListView = itemListView;

        api = new ItunesAPI();
        client = api.getClient();
    }

    public void searchWord (String word) {
        Call<TrackListDto> call =
                client.getListOfSongsWithNumberOfElements(word, 20);

        call.enqueue(new Callback<TrackListDto>() {
            @Override
            public void onResponse(@NonNull Call<TrackListDto> call, @NonNull Response<TrackListDto> response) {
                listDto = response.body();

                if (listDto.getResultCount() == 0){
                    itemListView.onError();
                } else {
                    itemList = listDto.getResults();
                    itemListView.addTrackList(listDto);
                }
            }

            @Override
            public void onFailure(Call<TrackListDto> call, Throwable throwable) {
                Log.d("fail", throwable.getMessage());
                itemListView.onError();
            }
        });
    }

    public void onItemSelected(int position) {
        itemListView.showDetails(itemList.get(position).getArtistName(),
                itemList.get(position).getTrackName(),
                itemList.get(position).getArtworkUrl100());
    }

}
