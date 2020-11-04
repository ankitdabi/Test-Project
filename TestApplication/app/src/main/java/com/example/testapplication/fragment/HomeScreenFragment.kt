package com.example.testapplication.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.example.testapplication.R
import com.google.android.material.tabs.TabLayout
import java.util.*


class HomeScreenFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home_screen, container, false)
        val viewPager = view.findViewById<View>(R.id.view_pager) as ViewPager
        setupViewPager(viewPager)

        /*getActivity().setTitle("Manage Tasks");*/
        // Set Tabs inside Toolbar

        /*getActivity().setTitle("Manage Tasks");*/
        // Set Tabs inside Toolbar
        val tabs = view.findViewById<View>(R.id.tab_layout) as TabLayout
        tabs.setupWithViewPager(viewPager)

        return view;
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = Adapter(childFragmentManager)
        adapter.addFragment(MoviesFragment(), "Movies")
        adapter.addFragment(SeriesFragment(), "Series")
        viewPager.adapter = adapter
        viewPager.offscreenPageLimit = 0
        viewPager.addOnPageChangeListener(object : OnPageChangeListener {
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

}
