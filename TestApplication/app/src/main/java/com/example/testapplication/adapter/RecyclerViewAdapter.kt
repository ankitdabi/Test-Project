package com.example.testapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.testapplication.OnRecyclerViewItemClickListener
import com.example.testapplication.R
import com.example.testapplication.fragment.AboutMovieActivity
import com.example.testapplication.bean.MovieResults
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.horizontal_cardview_movies.view.*
import java.util.*

class RecyclerViewAdapter(
    private val mMovies: ArrayList<MovieResults>?,
    internal var mContext: Context
) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    private var listener: OnRecyclerViewItemClickListener? = null
    private var verticalPosition: Int = 0

    var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(
            R.layout.horizontal_cardview_movies,
            parent,
            false
        )
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (mMovies != null) {
            holder.itemView.nameTV.text = mMovies[position].title
            Picasso.get().load("https://image.tmdb.org/t/p/w200" + mMovies[position].poster_path).into(
                holder.itemView.thumbnailIV
            )
            if (mMovies[position].release_date.length >= 5) {
                val date = mMovies[position].release_date.substring(0, 4)
                holder.itemView.releaseDateTV.text = date
            }
            val rating = java.lang.Double.toString(mMovies[position].vote_average)
            holder.itemView.ratingTV.text = rating
            holder.itemView.setOnClickListener { v ->
                if (listener != null)
                    listener!!.onRecyclerViewItemClicked(
                        verticalPosition,
                        position,
                        holder.itemView.thumbnailIV
                    )
            }

            holder.itemView.rootCV.setOnClickListener(View.OnClickListener {
                if (mMovies.get(position) != null) {
                    val activity = mContext as FragmentActivity
                    val fm = activity.supportFragmentManager
                    val alertDialog = AboutMovieActivity(
                        mMovies.get(position),
                        mMovies.get(position).id
                    )
                    alertDialog.show(fm, "Simple dialog")
                }
            })
        }
    }

    override fun getItemCount(): Int {
        return mMovies?.size ?: 0
    }


    fun setOnItemClickListener(listener: OnRecyclerViewItemClickListener, verticalPosition: Int) {
        this.listener = listener
        this.verticalPosition = verticalPosition
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}
