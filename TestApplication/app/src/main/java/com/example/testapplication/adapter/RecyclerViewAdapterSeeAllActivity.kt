package com.example.testapplication.adapter

import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testapplication.IntentConstants
import com.example.testapplication.R
import com.example.testapplication.bean.MovieResults
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.see_all_recyclerview_item.view.*
import java.util.ArrayList

class RecyclerViewAdapterSeeAllActivity(private val mMovies: ArrayList<MovieResults>?, internal var mContext: Context) : RecyclerView.Adapter<RecyclerViewAdapterSeeAllActivity.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.see_all_recyclerview_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (mMovies != null) {
            holder.itemView.nameTV.text = mMovies[position].title
            Picasso.get().load("https://image.tmdb.org/t/p/w200" + mMovies[position].poster_path).into(holder.itemView.thumbnailIV)
            if (mMovies[position].release_date.length >= 5) {
                val date = mMovies[position].release_date.substring(0, 4)
                holder.itemView.releaseDateTV.text = date
            }
            val rating = java.lang.Double.toString(mMovies[position].vote_average)
            holder.itemView.ratingTV.text = rating
            holder.itemView.rootCV.setOnClickListener { v ->
                val intent = Intent()
                val bundle = ActivityOptions.makeSceneTransitionAnimation(mContext as Activity, holder.itemView.thumbnailIV, holder.itemView.thumbnailIV.transitionName).toBundle()
                intent.putExtra("movie_id", mMovies[position].id)
                intent.putExtra("posterPath", mMovies[position].poster_path)
                intent.putExtra("movieName", mMovies[position].title)
                /*intent.setClass(mContext, AboutMovieActivity::class.java)*/
                mContext.startActivity(intent, bundle)
            }
        }
    }

    override fun getItemCount(): Int {
        return mMovies!!.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}