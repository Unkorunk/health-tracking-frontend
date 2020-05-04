package ru.timelimit.healthtracking

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.ui.AppBarConfiguration
import ru.timelimit.healthtracking.ui.calendar.CalendarFragment
import ru.timelimit.healthtracking.ui.health.HealthFragment


class MainActivity : AppCompatActivity() {

    private val onNavItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_calendar -> {
                val calendarFragment = CalendarFragment()
                title = getString(R.string.title_calendar)
                openFragment(calendarFragment)

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_contacts -> {
                //TODO: contacts fragment
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_diary -> {
                //TODO: diary fragment
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_health -> {
                val healthFragment = HealthFragment()
                title = getString(R.string.title_health)
                openFragment(healthFragment)

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_recommendations -> {
                //TODO: recommendations fragment
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        //val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications))
        //setupActionBarWithNavController(navController, appBarConfiguration)
        //navView.setupWithNavController(navController)
        navView.setOnNavigationItemSelectedListener(onNavItemSelectedListener)

        val defaultFragment = HealthFragment()
        title = getString(R.string.title_health)
        openFragment(defaultFragment)
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
