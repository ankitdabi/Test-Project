package com.example.testapplication.bean

import com.google.gson.annotations.SerializedName

data class SeriesResults (
    @SerializedName("original_name") val original_name : String,
    @SerializedName("genre_ids") val genre_ids : List<Int>,
    @SerializedName("name") val name : String,
    @SerializedName("popularity") val popularity : Double,
    @SerializedName("origin_country") val origin_country : List<String>,
    @SerializedName("vote_count") val vote_count : Int,
    @SerializedName("first_air_date") val first_air_date : String,
    @SerializedName("backdrop_path") val backdrop_path : String,
    @SerializedName("original_language") val original_language : String,
    @SerializedName("id") val id : Int,
    @SerializedName("vote_average") val vote_average : Double,
    @SerializedName("overview") val overview : String,
    @SerializedName("poster_path") val poster_path : String
)