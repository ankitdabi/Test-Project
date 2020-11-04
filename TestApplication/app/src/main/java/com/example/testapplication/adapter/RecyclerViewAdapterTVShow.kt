package com.example.testapplication.adapter

import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testapplication.*
import com.example.testapplication.bean.SeriesBean

class RecyclerViewAdapterTVShow(tvShows: Array<SeriesBean?>?, context: Context) :
    RecyclerView.Adapter<RecyclerViewAdapterTVShow.ViewHolder>(), OnRecyclerViewItemClickListener {
    private val mTVShows: Array<SeriesBean?>?
    var mContext: Context
    private var recyclerViewAdapter: RecyclerViewAdapterTVShowHorizontal? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.acitivity_main_second_tvshows, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (mTVShows != null && mTVShows.size > position) {
            if (getItemViewType(position) == 0) {
                if (mTVShows[position] != null) {
                    holder.tvShowType.text = "Airing Today"
                    holder.seeAlltextView.text = "See all"
                    /*holder.seeAlltextView.setOnClickListener { v: View? ->
                        val intent = Intent()
                        val bundle =
                            ActivityOptions.makeSceneTransitionAnimation(mContext as Activity)
                                .toBundle()
                        intent.putExtra("ABCD", mTVShows[position]!!.results)
                        intent.putExtra("TVSHOW_TYPE", "Airing Today")
                        *//*intent.setClass(mContext, SeeAllTVShowsActivity::class.java)*//*
                        mContext.startActivity(intent, bundle)
                    }*/
                    recyclerViewAdapter = RecyclerViewAdapterTVShowHorizontal(
                        mTVShows[position]!!.results,
                        mContext
                    )
                    holder.horizontalRecyclerView.adapter = recyclerViewAdapter
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
                    recyclerViewAdapter!!.setOnItemClickListener(this, position)
                }
            } else if (getItemViewType(position) == 1) {
                if (mTVShows[position] != null) {
                    holder.tvShowType.text = "On Air"
                    holder.seeAlltextView.text = "See all"
                    /*holder.seeAlltextView.setOnClickListener { v: View? ->
                        val intent = Intent()
                        val bundle =
                            ActivityOptions.makeSceneTransitionAnimation(mContext as Activity)
                                .toBundle()
                        *//*intent.setClass(mContext, SeeAllTVShowsActivity::class.java)*//*
                        intent.putExtra("ABCD", mTVShows[position]!!.results)
                        intent.putExtra("TVSHOW_TYPE", "On Air")
                        mContext.startActivity(intent, bundle)
                    }*/
                    recyclerViewAdapter = RecyclerViewAdapterTVShowHorizontal(
                        mTVShows[position]!!.results,
                        mContext
                    )
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
                if (mTVShows[position] != null) {
                    holder.tvShowType.text = "Popular Shows"
                    holder.seeAlltextView.text = "See all"
                    /*holder.seeAlltextView.setOnClickListener { v: View? ->
                        val intent = Intent()
                        val bundle =
                            ActivityOptions.makeSceneTransitionAnimation(mContext as Activity)
                                .toBundle()
                        intent.putExtra("ABCD", mTVShows[position]!!.results)
                        intent.putExtra("TVSHOW_TYPE", "Popular Shows")
                        *//*intent.setClass(mContext, SeeAllTVShowsActivity::class.java)*//*
                        mContext.startActivity(intent, bundle)
                    }*/
                    recyclerViewAdapter = RecyclerViewAdapterTVShowHorizontal(
                        mTVShows[position]!!.results,
                        mContext
                    )
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
                if (mTVShows[position] != null) {
                    holder.tvShowType.text = "Top Rated Shows"
                    holder.seeAlltextView.text = "See all"
                    /*holder.seeAlltextView.setOnClickListener { v: View? ->
                        val intent = Intent()
                        val bundle =
                            ActivityOptions.makeSceneTransitionAnimation(mContext as Activity)
                                .toBundle()
                        intent.putExtra("ABCD", mTVShows[position]!!.results)
                        intent.putExtra("TVSHOW_TYPE", "Top Rated Shows")
                        *//*intent.setClass(mContext, SeeAllTVShowsActivity::class.java)*//*
                        mContext.startActivity(intent, bundle)
                    }*/
                    recyclerViewAdapter = RecyclerViewAdapterTVShowHorizontal(
                        mTVShows[position]!!.results,
                        mContext
                    )
                    holder.horizontalRecyclerView.adapter = recyclerViewAdapter
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
                    recyclerViewAdapter!!.setOnItemClickListener(this, position)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return mTVShows!!.size
    }

    override fun getItemViewType(position: Int): Int {
        return position % 4
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvShowType: TextView
        var horizontalRecyclerView: RecyclerView
        var seeAlltextView: TextView

        init {
            tvShowType = itemView.findViewById(R.id.tvShowTypeTextView)
            seeAlltextView = itemView.findViewById(R.id.seeAllTextView)
            horizontalRecyclerView = itemView.findViewById(R.id.activityMainRecyclerViewHorizontal)
        }
    }

    init {
        mTVShows = tvShows
        mContext = context
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
            view!!.transitionName
        ).toBundle()
        /*intent.setClass(mContext, AboutTVShowActivity::class.java)*/
        intent.putExtra(
            "tvShow_id",
            mTVShows!![verticalPosition]!!.results!!.get(horizontalPosition)!!.id
        )
        intent.putExtra(
            "posterPath",
            mTVShows!![verticalPosition]!!.results!!.get(horizontalPosition)!!.poster_path
        )
        intent.putExtra(
            "tvShowName",
            mTVShows!![verticalPosition]!!.results!!.get(horizontalPosition)!!.name
        )
        mContext.startActivity(intent, bundle)
    }
}