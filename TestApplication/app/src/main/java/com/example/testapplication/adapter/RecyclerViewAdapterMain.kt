package com.example.testapplication.adapter

import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testapplication.*
import com.example.testapplication.activity.SeeAllMoviesActivity
import com.example.testapplication.bean.MovieBean

class RecyclerViewAdapterMain(movies: Array<MovieBean?>?, context: Context) :
    RecyclerView.Adapter<RecyclerViewAdapterMain.ViewHolder>(), OnRecyclerViewItemClickListener {
    private val mMovies: Array<MovieBean?>?
    var mContext: Context
    private var recyclerViewAdapter: RecyclerViewAdapter? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_main_second, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (mMovies != null && mMovies.size > position) {
            if (getItemViewType(position) == 0) {
                if (mMovies[position] != null) {
                    holder.movieType.text = "Popular Movies"
                    holder.seeAlltextView.text = "See all"
                    /*holder.seeAlltextView.setOnClickListener { v: View? ->
                        val intent = Intent()
                        val bundle =
                            ActivityOptions.makeSceneTransitionAnimation(mContext as Activity)
                                .toBundle()
                        intent.putExtra("ABCD", mMovies[position]?.results)
                        intent.putExtra("MOVIETYPE", "Popular Movies")
                        intent.setClass(mContext, SeeAllMoviesActivity::class.java)
                        mContext.startActivity(intent, bundle)
                    }*/
                    recyclerViewAdapter =
                        RecyclerViewAdapter(mMovies[position]?.results, mContext)
                    val horizontalManager =
                        LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false)
                    /*val gridLayoutManager = GridLayoutManager(mContext,2,RecyclerView.VERTICAL,false)*/
                    holder.horizontalRecyclerView.addItemDecoration(
                        HorizontalItemDecoration(
                            AppUtil.dpToPx(
                                mContext,
                                2
                            ), AppUtil.dpToPx(mContext, 2), AppUtil.dpToPx(mContext, 2)
                        )
                    )
                    holder.horizontalRecyclerView.layoutManager = horizontalManager
                    holder.horizontalRecyclerView.adapter = recyclerViewAdapter
                    recyclerViewAdapter!!.setOnItemClickListener(this, position)
                }
            } else if (getItemViewType(position) == 1) {
                if (mMovies[position] != null) {
                    holder.movieType.text = "Now Playing"
                    holder.seeAlltextView.text = "See all"
                    /*holder.seeAlltextView.setOnClickListener { v: View? ->
                        val intent = Intent()
                        val bundle =
                            ActivityOptions.makeSceneTransitionAnimation(mContext as Activity)
                                .toBundle()
                        intent.setClass(mContext, SeeAllMoviesActivity::class.java)
                        intent.putExtra("ABCD", mMovies[position]?.results)
                        intent.putExtra("MOVIETYPE", "Now Playing")
                        mContext.startActivity(intent, bundle)
                    }*/
                    recyclerViewAdapter =
                        RecyclerViewAdapter(mMovies[position]?.results, mContext)
                    val horizontalManager =
                        LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)
                    holder.horizontalRecyclerView.addItemDecoration(
                        HorizontalItemDecoration(
                            AppUtil.dpToPx(
                                mContext,
                                2
                            ), AppUtil.dpToPx(mContext, 2), AppUtil.dpToPx(mContext, 2)
                        )
                    )
                    holder.horizontalRecyclerView.layoutManager = horizontalManager
                    holder.horizontalRecyclerView.adapter = recyclerViewAdapter
                    recyclerViewAdapter!!.setOnItemClickListener(this, position)
                }
            } else if (getItemViewType(position) == 2) {
                if (mMovies[position] != null) {
                    holder.movieType.text = "Top Rated Movies"
                    holder.seeAlltextView.text = "See all"
                    /*holder.seeAlltextView.setOnClickListener { v: View? ->
                        val intent = Intent()
                        val bundle =
                            ActivityOptions.makeSceneTransitionAnimation(mContext as Activity)
                                .toBundle()
                        intent.putExtra("ABCD", mMovies[position]?.results)
                        intent.putExtra("MOVIETYPE", "Top Rated Movies")
                        intent.setClass(mContext, SeeAllMoviesActivity::class.java)
                        mContext.startActivity(intent, bundle)
                    }*/
                    recyclerViewAdapter =
                        RecyclerViewAdapter(mMovies[position]?.results, mContext)
                    val horizontalManager =
                        LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)
                    holder.horizontalRecyclerView.addItemDecoration(
                        HorizontalItemDecoration(
                            AppUtil.dpToPx(
                                mContext,
                                2
                            ), AppUtil.dpToPx(mContext, 2), AppUtil.dpToPx(mContext, 2)
                        )
                    )
                    holder.horizontalRecyclerView.layoutManager = horizontalManager
                    holder.horizontalRecyclerView.adapter = recyclerViewAdapter
                    recyclerViewAdapter!!.setOnItemClickListener(this, position)
                }
            } else if (getItemViewType(position) == 3) {
                if (mMovies[position] != null) {
                    holder.movieType.text = "Upcoming Movies"
                    holder.seeAlltextView.text = "See all"
                    /*holder.seeAlltextView.setOnClickListener { v: View? ->
                        val intent = Intent()
                        val bundle =
                            ActivityOptions.makeSceneTransitionAnimation(mContext as Activity)
                                .toBundle()
                        intent.putExtra("ABCD", mMovies[position]?.results)
                        intent.putExtra("MOVIETYPE", "Upcoming Movies")
                        intent.setClass(mContext, SeeAllMoviesActivity::class.java)
                        mContext.startActivity(intent, bundle)
                    }*/
                    recyclerViewAdapter =
                        RecyclerViewAdapter(mMovies[position]?.results, mContext)
                    val horizontalManager =
                        LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)
                    holder.horizontalRecyclerView.addItemDecoration(
                        HorizontalItemDecoration(
                            AppUtil.dpToPx(
                                mContext,
                                2
                            ), AppUtil.dpToPx(mContext, 2), AppUtil.dpToPx(mContext, 2)
                        )
                    )
                    holder.horizontalRecyclerView.layoutManager = horizontalManager
                    holder.horizontalRecyclerView.adapter = recyclerViewAdapter
                    recyclerViewAdapter!!.setOnItemClickListener(this, position)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return mMovies!!.size
    }

    override fun getItemViewType(position: Int): Int {
        return position % 4
    }

    override fun onRecyclerViewItemClicked(
        verticalPosition: Int,
        horizontalPosition: Int,
        view: View?
    ) {
        val intent = Intent()
        val bundle = ActivityOptions.makeSceneTransitionAnimation(
            mContext as Activity,
            view,
            view?.transitionName
        ).toBundle()
        //Bundle bundle = ActivityOptions.makeSceneTransitionAnimation((Activity) mContext).toBundle();
        /*intent.setClass(mContext, AboutMovieActivity::class.java)*/
        intent.putExtra(
            "movie_id",
            mMovies!![verticalPosition]?.results?.get(horizontalPosition)?.id
        )
        intent.putExtra(
            "posterPath",
            mMovies!![verticalPosition]?.results?.get(horizontalPosition)?.poster_path
        )
        intent.putExtra(
            "movieName",
            mMovies!![verticalPosition]?.results?.get(horizontalPosition)?.title
        )
        mContext.startActivity(intent, bundle)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var movieType: TextView
        var horizontalRecyclerView: RecyclerView
        var seeAlltextView: TextView

        init {
            movieType = itemView.findViewById(R.id.movieTypeTextView)
            seeAlltextView = itemView.findViewById(R.id.seeAllTextView)
            horizontalRecyclerView = itemView.findViewById(R.id.activityMainRecyclerViewHorizontal)
        }
    }

    init {
        mMovies = movies
        mContext = context
    }


}