package com.example.testapplication.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testapplication.R
import com.example.testapplication.adapter.RecyclerViewAdapterTVShow
import com.example.testapplication.bean.MovieBean
import com.example.testapplication.bean.MovieResults
import com.example.testapplication.bean.SeriesBean
import com.example.testapplication.bean.SeriesResults
import com.example.testapplication.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class SeriesFragment : Fragment() {

    var recyclerView: RecyclerView? = null
    var allTvShows: Array<SeriesBean?> ?=null
    var recyclerViewAdapterTVShow: RecyclerViewAdapterTVShow? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_series, container, false)

        recyclerView = view.findViewById(R.id.activityMainVerticalRecyclerView)
        allTvShows = arrayOfNulls<SeriesBean>(4)

        recyclerViewAdapterTVShow = RecyclerViewAdapterTVShow(allTvShows, activity!!)
        recyclerView!!.adapter = recyclerViewAdapterTVShow

        val verticalManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        recyclerView!!.layoutManager = verticalManager

        getSeriesData()
        return view
    }

    private fun getSeriesData() {

        RetrofitClient.getApiInterface()!!.getPopularSeries().enqueue(object : Callback<SeriesBean> {
            override fun onResponse(call: Call<SeriesBean>, response: Response<SeriesBean>) {
                if (response.body() != null) {
                    val movieList: ArrayList<SeriesResults> = response.body()!!.results
                    val popularMovies = SeriesBean(1, 10000, 500, movieList)
                    if (movieList == null) {
                        return
                    }
                    popularMovies.results
                    allTvShows!![0] = popularMovies
                    recyclerViewAdapterTVShow!!.notifyDataSetChanged()
                    /*Toast.makeText(context, "Success!", Toast.LENGTH_SHORT).show()*/
                }
            }
            override fun onFailure(call: Call<SeriesBean>, t: Throwable) {
                Toast.makeText(context, "Failure!", Toast.LENGTH_SHORT).show()
            }
        })

        RetrofitClient.getApiInterface()!!.getAiringSeries().enqueue(object : Callback<SeriesBean> {
            override fun onResponse(call: Call<SeriesBean>, response: Response<SeriesBean>) {
                if (response.body() != null) {
                    val movieList: ArrayList<SeriesResults> = response.body()!!.results
                    val airingSeries = SeriesBean(1, 10000, 500, movieList)
                    if (movieList == null) {
                        return
                    }
                    airingSeries.results
                    allTvShows!![1] = airingSeries
                    recyclerViewAdapterTVShow!!.notifyDataSetChanged()
                    /*Toast.makeText(context, "Success!", Toast.LENGTH_SHORT).show()*/
                }
            }

            override fun onFailure(call: Call<SeriesBean>, t: Throwable) {
                Toast.makeText(context, "Failure!", Toast.LENGTH_SHORT).show()
            }
        })

        RetrofitClient.getApiInterface()!!.getOnAirSeries().enqueue(object : Callback<SeriesBean> {
            override fun onResponse(call: Call<SeriesBean>, response: Response<SeriesBean>) {
                if (response.body() != null) {
                    val movieList: ArrayList<SeriesResults> = response.body()!!.results
                    val onAirSeries = SeriesBean(1, 10000, 500, movieList)
                    if (movieList == null) {
                        return
                    }
                    onAirSeries.results
                    allTvShows!![2] = onAirSeries
                    recyclerViewAdapterTVShow!!.notifyDataSetChanged()
                    /*Toast.makeText(context, "Success!", Toast.LENGTH_SHORT).show()*/
                }
            }

            override fun onFailure(call: Call<SeriesBean>, t: Throwable) {
                Toast.makeText(context, "Failure!", Toast.LENGTH_SHORT).show()
            }
        })

        RetrofitClient.getApiInterface()!!.getTopRatedSeries().enqueue(object : Callback<SeriesBean> {
            override fun onResponse(call: Call<SeriesBean>, response: Response<SeriesBean>) {
                if (response.body() != null) {
                    val movieList: ArrayList<SeriesResults> = response.body()!!.results
                    val onAirSeries = SeriesBean(1, 10000, 500, movieList)
                    if (movieList == null) {
                        return
                    }
                    onAirSeries.results
                    allTvShows!![3] = onAirSeries
                    recyclerViewAdapterTVShow!!.notifyDataSetChanged()
                    /*Toast.makeText(context, "Success!", Toast.LENGTH_SHORT).show()*/
                }
            }
            override fun onFailure(call: Call<SeriesBean>, t: Throwable) {
                Toast.makeText(context, "Failure!", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
