package com.josegonzalez.musicsearchsample.repository

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ItunesAPI {

    private val httpClient = OkHttpClient.Builder()
    private val builder = Retrofit.Builder()
            .baseUrl(API)
            .addConverterFactory(
                    GsonConverterFactory.create()
            )
    private val retrofit = builder.client(httpClient.build()).build()

    val client: ItunesClient = retrofit.create(ItunesClient::class.java)

    companion object {
        private const val API = "https://itunes.apple.com"
    }

}