package br.com.cotemig.instagram.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    private val url = "https://mockup.fluo.app/v1/";

    private val retrofit =
        Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build()

    fun getPostService() : PostService{
        return retrofit.create(PostService::class.java)
    }
}