package com.example.testapplication.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager

import com.example.testapplication.R
import com.example.testapplication.bean.MovieResults
import com.example.testapplication.bean.SeriesResults
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.tabs.TabLayout
import com.squareup.picasso.Picasso
import java.util.ArrayList


class AboutSeriesFragment(get: SeriesResults, id: Int) : BottomSheetDialogFragment() {

    var bannerImage : ImageView? = null
    var posterImage : ImageView? = null
    var releaseYear : TextView? = null
    var movieTime : TextView? =null
    var movieName : TextView? = null

    var seriesResults: SeriesResults? = null
    private var seriesId = 0

    init {
        seriesResults = get
        seriesId = id
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_about_series, container, false)


        bannerImage = view.findViewById(R.id.bannerImage)
        posterImage = view.findViewById(R.id.posterWithBannerImageView)
        releaseYear = view.findViewById(R.id.releaseDateTextView)
        movieTime = view.findViewById(R.id.runTimeTextView)
        movieName = view.findViewById(R.id.nameTextView)

        val viewPager = view.findViewById<View>(R.id.container) as ViewPager
        setupViewPager(viewPager)

        val tabs = view.findViewById<View>(R.id.tabLayout) as TabLayout
        tabs.setupWithViewPager(viewPager)

        setSeriesDetails()

        return view
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = HomeScreenFragment.Adapter(childFragmentManager)
        adapter.addFragment(InfoAboutMovieFragment(), "INFO")
        adapter.addFragment(ReviewsFragment(), "REVIEWS")
        viewPager.adapter = adapter
        viewPager.offscreenPageLimit = 0
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }
            override fun onPageSelected(position: Int) {
                /*if (position == 1) {
                    val listFragment: TaskList = adapter.getItem(1) as TaskList
                    listFragment.updateTask()
                }*/
            }
            override fun onPageScrollStateChanged(state: Int) {}
        })
    }

    internal class Adapter(manager: FragmentManager?) :
        FragmentPagerAdapter(manager!!) {
        private val mFragmentList: MutableList<Fragment> = ArrayList()
        private val mFragmentTitleList: MutableList<String> = ArrayList()
        override fun getItem(position: Int): Fragment {
            return mFragmentList[position]
        }

        override fun getCount(): Int {
            return mFragmentList.size
        }

        fun addFragment(fragment: Fragment, title: String) {
            mFragmentList.add(fragment)
            mFragmentTitleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return mFragmentTitleList[position]
        }
    }

    private fun setSeriesDetails() {

        val mo : Double = seriesResults!!.vote_average
        val str : String = mo.toString()

        Picasso.get().load("https://image.tmdb.org/t/p/w200" + seriesResults?.backdrop_path).into(
            bannerImage
        )
        Picasso.get().load("https://image.tmdb.org/t/p/w200" + seriesResults?.poster_path).into(
            posterImage
        )
        movieName!!.setText(seriesResults?.original_name)
        releaseYear!!.setText(seriesResults?.first_air_date)
        movieTime!!.setText(str)
    }
}
