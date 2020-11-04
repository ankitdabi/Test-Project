package com.example.testapplication.activity

import android.os.Bundle
import android.transition.Slide
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testapplication.*
import com.example.testapplication.adapter.RecyclerViewAdapterSeeAllActivity
import com.example.testapplication.bean.MovieBean
import com.example.testapplication.bean.MovieResults
import com.example.testapplication.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class SeeAllMoviesActivity : AppCompatActivity() {
    private var scrollListener: EndlessRecyclerViewScrollListener? = null
    var recyclerView: RecyclerView? = null
    var adapter: RecyclerViewAdapterSeeAllActivity? = null
    var movies: ArrayList<MovieResults>? = null
    var movieType: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.see_all_activity_movie)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val slide = Slide(Gravity.BOTTOM)
        window.enterTransition = slide
        window.allowEnterTransitionOverlap = true
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        val intent = intent


        movies = intent.getSerializableExtra("ABCD") as ArrayList<MovieResults>?
        movieType = intent.getStringExtra("MOVIETYPE")
        title = movieType
        recyclerView = findViewById(R.id.seeAllActivityRecyclerViewMovies)
        val spacingInPixels = resources.getDimensionPixelSize(R.dimen.spacing)
        recyclerView!!.addItemDecoration(SpacesItemDecoration(spacingInPixels))

        adapter = RecyclerViewAdapterSeeAllActivity(movies, this)
        val gridLayoutManager = GridLayoutManager(this, 2, RecyclerView.VERTICAL, false)
        recyclerView!!.addItemDecoration(
            GridSpacingItemDecoration(
                2,
                AppUtil.dpToPx(this, 16),
                true
            )
        )
        recyclerView!!.setLayoutManager(gridLayoutManager)
        recyclerView!!.setAdapter(adapter)
        scrollListener = object : EndlessRecyclerViewScrollListener(gridLayoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {
                loadMoreData(page)
            }
        }
        recyclerView!!.addOnScrollListener(scrollListener as EndlessRecyclerViewScrollListener)
    }

    private fun loadMoreData(page: Int) {

        if (movieType == "Popular Movies") {

            RetrofitClient.getApiInterface()!!.getMoviesData()
                .enqueue(object : Callback<MovieBean> {
                    override fun onResponse(call: Call<MovieBean>, response: Response<MovieBean>) {
                        if (response.body() != null) {
                            val movieList: ArrayList<MovieResults> = response.body()!!.results
                            val popularMovies = MovieBean(1, 10000, 500, movieList)
                            if (movieList == null) {
                                return
                            }
                            for (obj in movieList) {
                                movies!!.add(obj)
                            }
                            adapter!!.notifyDataSetChanged()

                            Toast.makeText(
                                this@SeeAllMoviesActivity,
                                "Success!",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                    override fun onFailure(call: Call<MovieBean>, t: Throwable) {
                        Toast.makeText(this@SeeAllMoviesActivity, "Failure!", Toast.LENGTH_SHORT)
                            .show()
                    }

                })
        } /*else if (movieType == "Now Playing") {
            val call: Call<MovieResponse> = service.getNowPlayingMovies(URLConstants.API_KEY, page)
            call.enqueue(object : Callback<MovieResponse> {
                override fun onResponse(
                    call: Call<MovieResponse>,
                    response: Response<MovieResponse>
                ) {
                    val movieList: ArrayList<Movie> = response.body().getMovies()
                        ?: return
                    for (obj in movieList) {
                        movies!!.add(obj)
                    }
                    adapter.notifyDataSetChanged()
                }

                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {}
            })
        } else if (movieType == "Top Rated Movies") {
            val call: Call<MovieResponse> = service.getTopRatedMovies(URLConstants.API_KEY, page)
            call.enqueue(object : Callback<MovieResponse> {
                override fun onResponse(
                    call: Call<MovieResponse>,
                    response: Response<MovieResponse>
                ) {
                    //Log.i("ABC2", "FUN");
                    val movieList: ArrayList<Movie> = response.body().getMovies() ?: return
                    for (obj in movieList) {
                        movies!!.add(obj)
                    }
                    adapter.notifyDataSetChanged()
                }

                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {}
            })
        } else if (movieType == "Upcoming Movies") {
            val call: Call<MovieResponse> = service.getUpcomingMovies(URLConstants.API_KEY, page)
            call.enqueue(object : Callback<MovieResponse> {
                override fun onResponse(
                    call: Call<MovieResponse>,
                    response: Response<MovieResponse>
                ) {
                    val movieList: ArrayList<Movie> = response.body().getMovies()
                        ?: return
                    for (obj in movieList) {
                        movies!!.add(obj)
                    }
                    adapter.notifyDataSetChanged()
                }

                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {}
            })
        }
    }*/
    }

        override fun onSupportNavigateUp(): Boolean {
            onBackPressed()
            return true
        }
}