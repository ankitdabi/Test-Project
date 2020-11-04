package com.example.testapplication.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.example.testapplication.R
import com.example.testapplication.bean.MovieResults
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.tabs.TabLayout
import com.squareup.picasso.Picasso

class AboutMovieActivity(get: MovieResults, id: Int) : BottomSheetDialogFragment() {

    var bannerImage : ImageView ? = null
    var posterImage : ImageView? = null
    var releaseYear : TextView? = null
    var movieTime : TextView? =null
    var movieName : TextView? = null
    private var tabLayout: TabLayout? = null
    private var mViewPager: ViewPager? = null

    var movieResult: MovieResults? = null
    private var taskid = 0

    init {
        movieResult = get
        taskid = id
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.activity_about_movie, container, false)

        bannerImage = view.findViewById(R.id.bannerImage)
        posterImage = view.findViewById(R.id.posterWithBannerImageView)
        releaseYear = view.findViewById(R.id.releaseDateTextView)
        movieTime = view.findViewById(R.id.runTimeTextView)
        movieName = view.findViewById(R.id.nameTextView)

        tabLayout = view.findViewById<TabLayout>(R.id.tabLayout)
        mViewPager = view.findViewById<ViewPager>(R.id.container)

        tabLayout.addTab(tabLayout.newTab())
        tabLayout.addTab(tabLayout.newTab())
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL)

        setMovieDetails()
        return view
    }

    private fun setMovieDetails() {

        val mo : Double = movieResult!!.vote_average
        val str : String = mo.toString()


        Picasso.get().load("https://image.tmdb.org/t/p/w200" + movieResult?.backdrop_path).into(
            bannerImage
        )
        Picasso.get().load("https://image.tmdb.org/t/p/w200" + movieResult?.poster_path).into(
            posterImage
        )
        movieName!!.setText(movieResult?.original_title)
        releaseYear!!.setText(movieResult?.release_date)
        movieTime!!.setText(str)
    }
}
