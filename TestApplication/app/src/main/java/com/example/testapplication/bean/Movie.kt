package com.example.testapplication.bean

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.util.*

class Movie (var movieId: Int?, val originalName: String?, val voteAvg : Double?, val poster : String ) {
    @SerializedName("poster_path")
    var posterPath: String? = null

    @SerializedName("adult")
    var isAdult = false

    @SerializedName("overview")
    var overview: String? = null

    @SerializedName("release_date")
    var releaseDate: String? = null

    @SerializedName("genre_ids")
    var genreIds: List<Int?> = ArrayList()

    @SerializedName("id")
    var id: Int? = null

    @SerializedName("original_title")
    var originalTitle: String? = null

    @SerializedName("original_language")
    var originalLanguage: String? = null

    @SerializedName("title")
    var title: String? = null

    @SerializedName("backdrop_path")
    var backdropPath: String? = null

    @SerializedName("popularity")
    var popularity: Double? = null

    @SerializedName("vote_count")
    var voteCount: Int? = null

    @SerializedName("video")
    var video: Boolean? = null

    @SerializedName("vote_average")
    var voteAverage: Double? = null

/*
    constructor() {}
*/
}