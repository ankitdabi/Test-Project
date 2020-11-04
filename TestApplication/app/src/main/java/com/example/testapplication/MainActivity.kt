package com.example.testapplication

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import com.example.testapplication.R
import com.example.testapplication.fragment.HomeScreenFragment
import com.example.testapplication.fragment.SaveScreenFragment
import com.google.android.material.bottomnavigation.BottomNavigationMenu
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{

    private var drawerLayout: DrawerLayout? = null
    private var toggle: androidx.appcompat.app.ActionBarDrawerToggle? = null
    private var id = 0
    private var navigationView: NavigationView? = null
    private lateinit var navController: NavController
    private var bottomNavigationMenu : BottomNavigationMenu? = null

    private val mBottomNavigationMenu = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when(item.itemId){
            R.id.home_screen_bottom -> {
                supportFragmentManager.beginTransaction().replace(
                    R.id.fragment_container,
                    HomeScreenFragment()
                ).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.saves_screen_bottom -> {
                supportFragmentManager.beginTransaction().replace(
                    R.id.fragment_container,
                    SaveScreenFragment()
                ).commit()
                return@OnNavigationItemSelectedListener true
            }
            else ->
                return@OnNavigationItemSelectedListener false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // defined variable
        drawerLayout = findViewById(R.id.drawer)
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout!!.addDrawerListener(toggle!!)
        toggle!!.syncState()
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        navigationView = findViewById<View>(R.id.navigationView) as NavigationView
        navigationView!!.setNavigationItemSelectedListener(this)
        main_bottom_navigation_view.setOnNavigationItemSelectedListener(mBottomNavigationMenu)

        //I added this if statement to keep the selected fragment when rotating the device
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(
                R.id.fragment_container,
                HomeScreenFragment()
            ).commit()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (toggle!!.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        id = p0.getItemId()

        when(id){

            R.id.home_screen -> {
                drawerLayout!!.closeDrawers()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, HomeScreenFragment())
                    .addToBackStack(null)
                    .commit()
            }
            R.id.saves_screen -> {
                drawerLayout!!.closeDrawers()
                supportFragmentManager.beginTransaction().replace(
                    R.id.fragment_container,
                    SaveScreenFragment()
                ).commit()
            }
        }

        return true
    }
}
