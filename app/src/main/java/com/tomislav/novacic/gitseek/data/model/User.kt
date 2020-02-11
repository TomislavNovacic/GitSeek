package com.tomislav.novacic.gitseek.data.model

import com.squareup.moshi.Json

data class User(
    @Json(name = "login")
    val login: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "node_id")
    val nodeId: String,
    @Json(name = "avatar_url")
    val avatarUrl: String,
    @Json(name = "gravatar_id")
    val gravatarId: String,
    @Json(name = "url")
    val url: String,
    @Json(name = "html_url")
    val htmlUrl: String,
    @Json(name = "followers_url")
    val followersUrl: String,
    @Json(name = "subscriptions_url")
    val subscriptionsUrl: String,
    @Json(name = "organizations_url")
    val organizationsUrl: String,
    @Json(name = "repos_url")
    val reposUrl: String,
    @Json(name = "received_events_url")
    val receivedEventsUrl: String,
    @Json(name = "type")
    val type: String,
    @Json(name = "score")
    val score: Double
)