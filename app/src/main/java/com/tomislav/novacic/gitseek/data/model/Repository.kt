package com.tomislav.novacic.gitseek.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Repository(
    @Json(name = "id")
    val id: Int,
    @Json(name = "node_id")
    val nodeId: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "full_name")
    val fullName: String,
    @Json(name = "owner")
    val owner: User,
    @Json(name = "private")
    val `private`: Boolean,
    @Json(name = "html_url")
    val htmlUrl: String,
    @Json(name = "description")
    val description: String,
    @Json(name = "fork")
    val fork: Boolean,
    @Json(name = "url")
    val url: String,
    @Json(name = "created_at")
    val createdAt: String,
    @Json(name = "updated_at")
    val updatedAt: String,
    @Json(name = "pushed_at")
    val pushedAt: String,
    @Json(name = "homepage")
    val homepage: String,
    @Json(name = "size")
    val size: Int,
    @Json(name = "stargazers_count")
    val stargazersCount: Int,
    @Json(name = "watchers_count")
    val watchersCount: Int,
    @Json(name = "language")
    val language: String,
    @Json(name = "forks_count")
    val forksCount: Int,
    @Json(name = "open_issues_count")
    val openIssuesCount: Int,
    @Json(name = "master_branch")
    val masterBranch: String,
    @Json(name = "default_branch")
    val defaultBranch: String,
    @Json(name = "score")
    val score: Double
) : Parcelable
