package com.example.testapplication.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.testapplication.R


class InfoAboutMovieFragment : Fragment() {

    private var abouFilmTextView: TextView? = null
    private var releasedTextView: TextView? = null
    private var budgetTextView: TextView? = null
    private val seeAlltextViewMovieInfofragment: TextView? = null
    private var noReviewMovieTextView: TextView? = null
    private var noSimilarMoviesTextView: TextView? = null
    private var revenueTextView: TextView? = null

    fun newInstance(): InfoAboutMovieFragment? {
        return InfoAboutMovieFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_info_about_movie, container, false)

        abouFilmTextView = view.findViewById(R.id.aboutFilmTextView)
        releasedTextView = view.findViewById(R.id.releasedTextView)
        budgetTextView = view.findViewById(R.id.budgetTextView)
        revenueTextView = view.findViewById(R.id.revenueTextView)

        getMoviesData()

        return view
    }

    private fun getMoviesData() {

    }
}
