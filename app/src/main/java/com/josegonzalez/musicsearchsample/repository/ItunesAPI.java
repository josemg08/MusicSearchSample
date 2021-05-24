package com.josegonzalez.musicsearchsample.repository;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ItunesAPI {

    private static final String API = "https://itunes.apple.com";

    private OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private Retrofit.Builder builder = new Retrofit.Builder()
                    .baseUrl(API)
                    .addConverterFactory(
                            GsonConverterFactory.create()
                    );

    private Retrofit retrofit = builder.client(httpClient.build()).build();

    private ItunesClient client = retrofit.create(ItunesClient.class);

    public ItunesClient getClient() {
        return client;
    }

}
