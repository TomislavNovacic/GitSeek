package com.tomislav.novacic.gitseek.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SearchResult(
    @Json(name = "total_count")
    val totalCount: Int,
    @Json(name = "items")
    val repositoryDetailsList: List<Repository>,
    @Json(name = "incomplete_results")
    val incompleteResults: Boolean
)