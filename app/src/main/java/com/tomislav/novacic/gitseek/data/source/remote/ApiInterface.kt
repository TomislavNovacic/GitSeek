package com.tomislav.novacic.gitseek.data.source.remote

import com.tomislav.novacic.gitseek.data.model.SearchResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("/search/repositories")
    fun getRepositories(@Query("q") searchKeywords: String?, @Query("sort") sort: String?): Call<SearchResult>
}