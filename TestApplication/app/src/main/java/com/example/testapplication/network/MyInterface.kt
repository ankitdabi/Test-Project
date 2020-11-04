package com.example.testapplication.network

import com.example.testapplication.bean.MovieBean
import com.example.testapplication.bean.SeriesBean
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MyInterface {

    @GET("3/movie/popular?api_key=60af9fe8e3245c53ad9c4c0af82d56d6&language=en-US&page=1")
    fun getMoviesData(): Call<MovieBean>

    @GET("3/movie/now_playing?api_key=60af9fe8e3245c53ad9c4c0af82d56d6&language=en-US&page=1")
    fun getNowPlaying(): Call<MovieBean>

    @GET("3/movie/top_rated?api_key=60af9fe8e3245c53ad9c4c0af82d56d6&language=en-US&page=1")
    fun getTopRated(): Call<MovieBean>

    @GET("3/movie/upcoming?api_key=60af9fe8e3245c53ad9c4c0af82d56d6&language=en-US&page=1")
    fun getUpcomingMovies(): Call<MovieBean>

    @GET("3/tv/popular?api_key=60af9fe8e3245c53ad9c4c0af82d56d6&language=en-US&page=1")
    fun getPopularSeries(): Call<SeriesBean>

    @GET("3/tv/airing_today?api_key=60af9fe8e3245c53ad9c4c0af82d56d6&language=en-US&page=1")
    fun getAiringSeries(): Call<SeriesBean>

    @GET("3/tv/on_the_air?api_key=60af9fe8e3245c53ad9c4c0af82d56d6&language=en-US&page=1")
    fun getOnAirSeries(): Call<SeriesBean>

    @GET("3/tv/top_rated?api_key=60af9fe8e3245c53ad9c4c0af82d56d6&language=en-US&page=1")
    fun getTopRatedSeries(): Call<SeriesBean>


}