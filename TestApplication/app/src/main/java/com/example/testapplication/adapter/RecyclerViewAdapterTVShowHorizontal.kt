package com.example.testapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.testapplication.OnRecyclerViewItemClickListener
import com.example.testapplication.R
import com.example.testapplication.bean.SeriesResults
import com.squareup.picasso.Picasso
import java.util.*

class RecyclerViewAdapterTVShowHorizontal(tvShows: ArrayList<SeriesResults>?, context: Context) :
    RecyclerView.Adapter<RecyclerViewAdapterTVShowHorizontal.ViewHolder>() {
    private val mTVShows: ArrayList<SeriesResults>?
    var mContext: Context
    private var listener: OnRecyclerViewItemClickListener? = null
    private var verticalPosition = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.horizontal_cardview_tvshows, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (mTVShows != null) {
            holder.tvShowName.setText(mTVShows[position].name)
            Picasso.get().load("https://image.tmdb.org/t/p/w200" + mTVShows[position].poster_path)
                .into(holder.tvShowThumbnailImage)
            if (mTVShows[position].first_air_date.length >= 5) {
                val date: String = mTVShows[position].first_air_date.substring(0, 4)
                holder.tvShowReleaseDate.text = date
            }
            val rating = java.lang.Double.toString(mTVShows[position].vote_average).substring(0, 3)
            holder.rating.text = rating
            holder.cv.setOnClickListener { v: View? ->
                if (listener != null) listener!!.onRecyclerViewItemClicked(
                    verticalPosition,
                    position,
                    holder.tvShowThumbnailImage
                )
            }
        }
    }

    override fun getItemCount(): Int {
        return mTVShows!!.size
    }

    fun setOnItemClickListener(listener: OnRecyclerViewItemClickListener?, verticalPosition: Int) {
        this.listener = listener
        this.verticalPosition = verticalPosition
    }

    class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cv: CardView
        var tvShowThumbnailImage: ImageView
        var tvShowName: TextView
        var tvShowReleaseDate: TextView
        var rating: TextView

        init {
            cv = itemView.findViewById(R.id.cardView)
            tvShowThumbnailImage = itemView.findViewById(R.id.tvShowThumbnailImageView)
            tvShowName = itemView.findViewById(R.id.tvShowNameTextView)
            tvShowReleaseDate = itemView.findViewById(R.id.tvShowReleaseDateTextView)
            rating = itemView.findViewById(R.id.ratingTextView)
        }
    }

    init {
        mTVShows = tvShows
        mContext = context
    }
}
