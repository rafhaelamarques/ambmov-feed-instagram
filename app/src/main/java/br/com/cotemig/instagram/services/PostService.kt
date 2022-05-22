package br.com.cotemig.instagram.services

import br.com.cotemig.instagram.models.Post
import retrofit2.Call
import retrofit2.http.GET

interface PostService {

    @GET("feed")
    fun getFeed(): Call<List<Post>>
}