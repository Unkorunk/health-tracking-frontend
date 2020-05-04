package ru.timelimit.healthtracking

import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentManager.POP_BACK_STACK_INCLUSIVE
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import com.android.volley.toolbox.Volley
import ru.timelimit.healthtracking.ui.auth.GreetingFragment
import ru.timelimit.healthtracking.ui.calendar.CalendarFragment
import ru.timelimit.healthtracking.ui.contacts.ContactsFragment
import ru.timelimit.healthtracking.ui.health.HealthFragment
import ru.timelimit.healthtracking.ui.home.HomeFragment
import ru.timelimit.healthtracking.ui.recommendation.RecommendationFragment


class MainActivity : AppCompatActivity() {

    private lateinit var navView : BottomNavigationView
    private lateinit var authNavigation : View

    private val onNavItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_calendar -> {
                val calendarFragment = CalendarFragment()
                title = getString(R.string.title_calendar)
                openFragment(calendarFragment)

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_contacts -> {
                val contactsFragment = ContactsFragment()
                title = getString(R.string.title_contacts)
                openFragment(contactsFragment)

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
                val recommendationFragment = RecommendationFragment()
                title = getString(R.string.title_recommendations)
                openFragment(recommendationFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }


    private lateinit var container : ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        inst = this

        GlobalStorage.requestQueue = Volley.newRequestQueue(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navView = findViewById(R.id.nav_view)

        container = findViewById(R.id.container)
        navView.visibility = View.INVISIBLE
        //val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        val appBarConfiguration = AppBarConfiguration(setOf(
//                R.id.nav_greetings, R.id.navigation_dashboard, R.id.navigation_notifications))
        //setupActionBarWithNavController(navController, appBarConfiguration)
        //navView.setupWithNavController(navController)
        navView.setOnNavigationItemSelectedListener(onNavItemSelectedListener)

        authNavigation = findViewById(R.id.nav_host_fragment)
//        val defaultFragment = GreetingFragment()
//        title = getString(R.string.greeting)
//        openFragment(defaultFragment)
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.current_frame, fragment)

        //transaction.addToBackStack(null)

        transaction.commit()
    }

    override fun onBackPressed() {
        val selectedItem = navView.selectedItemId

        if (R.id.navigation_health != selectedItem) {
            navView.selectedItemId = R.id.navigation_health
        } else {
            super.onBackPressed()
        }
    }

    companion object {
        @JvmStatic
        private lateinit var inst : MainActivity

        fun Auth() {
            inst.navView.visibility = View.VISIBLE
            inst.authNavigation.visibility = View.GONE

            inst.title = inst.getString(R.string.title_health)
            inst.openFragment(HealthFragment())
        }
    }
}
