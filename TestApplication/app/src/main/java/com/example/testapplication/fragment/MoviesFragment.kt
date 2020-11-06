package com.example.testapplication.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testapplication.AppUtil
import com.example.testapplication.GridSpacingItemDecoration
import com.example.testapplication.R
import com.example.testapplication.adapter.RecyclerViewAdapterMain
import com.example.testapplication.bean.MovieBean
import com.example.testapplication.bean.MovieResults
import com.example.testapplication.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*


class MoviesFragment : androidx.fragment.app.Fragment() {

    private var recyclerView: RecyclerView? = null
    private var allMovies: Array<MovieBean?> ?= null
    private var recyclerViewAdapterMain: RecyclerViewAdapterMain? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_movies, container, false)
        recyclerView = view.findViewById(R.id.activityMainVerticalRecyclerView)
        allMovies = arrayOfNulls<MovieBean>(4)
        recyclerViewAdapterMain = RecyclerViewAdapterMain(allMovies, activity!!)
        recyclerView!!.setLayoutManager(LinearLayoutManager(activity, RecyclerView.VERTICAL, false))
        recyclerView!!.setAdapter(recyclerViewAdapterMain)

        getMoviesData()
        return view
    }


private fun getMoviesData() {

    RetrofitClient.getApiInterface()!!.getMoviesData().enqueue(object : Callback<MovieBean> {
        override fun onResponse(call: Call<MovieBean>, response: Response<MovieBean>) {
            if (response.body() != null) {
                val movieList: ArrayList<MovieResults> = response.body()!!.results
                val popularMovies = MovieBean(1, 10000, 500, movieList)
                if (movieList == null) {
                    return
                }
                popularMovies.results
                allMovies!![0] = popularMovies
                recyclerViewAdapterMain!!.notifyDataSetChanged()
                /*Toast.makeText(context, "Success!", Toast.LENGTH_SHORT).show()*/
            }
        }

        override fun onFailure(call: Call<MovieBean>, t: Throwable) {
            Toast.makeText(context, "Failure!", Toast.LENGTH_SHORT).show()
        }

    })


    RetrofitClient.getApiInterface()!!.getNowPlaying().enqueue(object : Callback<MovieBean> {
        override fun onResponse(call: Call<MovieBean>, response: Response<MovieBean>) {
            if (response.body() != null) {
                val movieList: ArrayList<MovieResults> = response.body()!!.results
                val recentMovies = MovieBean(1, 10000, 500, movieList)
                if (movieList == null) {
                    return
                }
                recentMovies.results
                allMovies!![1] = recentMovies
                recyclerViewAdapterMain!!.notifyDataSetChanged()
                /*Toast.makeText(context, "Success!", Toast.LENGTH_SHORT).show()*/
            }
        }

        override fun onFailure(call: Call<MovieBean>, t: Throwable) {
            Toast.makeText(context, "Failure!", Toast.LENGTH_SHORT).show()
        }

    })

    RetrofitClient.getApiInterface()!!.getTopRated().enqueue(object : Callback<MovieBean> {
        override fun onResponse(call: Call<MovieBean>, response: Response<MovieBean>) {
            if (response.body() != null) {
                val movieList: ArrayList<MovieResults> = response.body()!!.results
                val newMovies = MovieBean(1, 10000, 500, movieList)
                if (movieList == null) {
                    return
                }
                newMovies.results
                allMovies!![2] = newMovies
                recyclerViewAdapterMain!!.notifyDataSetChanged()
/*
                Toast.makeText(context, "Success!", Toast.LENGTH_SHORT).show()
*/
            }
        }

        override fun onFailure(call: Call<MovieBean>, t: Throwable) {
            Toast.makeText(context, "Failure!", Toast.LENGTH_SHORT).show()
        }

    })

    RetrofitClient.getApiInterface()!!.getUpcomingMovies().enqueue(object : Callback<MovieBean> {
        override fun onResponse(call: Call<MovieBean>, response: Response<MovieBean>) {
            if (response.body() != null) {
                val movieList: ArrayList<MovieResults> = response.body()!!.results
                val trending = MovieBean(1, 10000, 500, movieList)
                if (movieList == null) {
                    return
                }
                trending.results
                allMovies!![3] = trending
                recyclerViewAdapterMain!!.notifyDataSetChanged()
                /*Toast.makeText(context, "Success!", Toast.LENGTH_SHORT).show()*/
            }
        }

        override fun onFailure(call: Call<MovieBean>, t: Throwable) {
            Toast.makeText(context, "Failure!", Toast.LENGTH_SHORT).show()
        }

    })

    }
}
