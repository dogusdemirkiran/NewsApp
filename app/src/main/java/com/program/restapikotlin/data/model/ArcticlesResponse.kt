package com.program.restapikotlin.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.SerialInfo
import kotlinx.serialization.Serializable

@Serializable
data class ArcticlesResponse (
    val status: String?,
    val totalResults: Int?,
    val articles: List<Article>?,
)

@Serializable
@Parcelize
data class Article(
    val source: Source?,
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String?,
): Parcelable

@Serializable
@Parcelize
data class Source(
    //val id: Any?,
    val name: String?,
): Parcelable