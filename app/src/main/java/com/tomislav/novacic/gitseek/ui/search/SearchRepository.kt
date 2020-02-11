package com.tomislav.novacic.gitseek.ui.search

import androidx.lifecycle.MutableLiveData
import com.tomislav.novacic.gitseek.data.model.SearchResult
import com.tomislav.novacic.gitseek.data.source.remote.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchRepository @Inject constructor(private val apiInterface: ApiInterface) {
    //TODO Add Single Source of Truth (Room)
    fun getRepositories(searchKeywords: String, sort: String?): MutableLiveData<SearchResult> {
        val data = MutableLiveData<SearchResult>()
        apiInterface.getRepositories(searchKeywords, sort).enqueue(object : Callback<SearchResult> {
                override fun onResponse(call: Call<SearchResult>, response: Response<SearchResult>) {
                    data.value = response.body()
                }

                override fun onFailure(call: Call<SearchResult>, t: Throwable) {
                    TODO()
                }
            })
        return data
    }
}