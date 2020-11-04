package com.example.testapplication.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.testapplication.fragment.MoviesFragment
import com.example.testapplication.fragment.SeriesFragment

class ViewPageAdapter (private val context: Context, fragmentManager : FragmentManager, internal var totalTabs : Int): FragmentPagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> {
                    return MoviesFragment()
            }
            1 -> {
                    return SeriesFragment()
            }
            else -> return getItem(position)
        }
    }

    override fun getCount(): Int {
        return totalTabs
        TODO("Not yet implemented")
    }
}