package ru.timelimit.healthtracking.ui.calendar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import ru.timelimit.healthtracking.R

class CalendarFragment : Fragment() {

    private lateinit var calendarViewModel: CalendarViewModel

    private val arr = mutableListOf<String>( "a", "ababab", "caba", "sadfasfdasfdjashfkahsfkahskfdjasdfkasjhfdkashfjak", "tmp1", "tmp2", "", " ", "tmp3", "tmp4")

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        calendarViewModel =
                ViewModelProviders.of(this).get(CalendarViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_calendar, container, false)

        val list = root.findViewById<ListView>(R.id.calendar_list)

        list.adapter = ArrayAdapter<String>(this.context!!, R.layout.calendar_list_item, arr)
//        val textView: TextView = root.findViewById(R.id.text_health)
//        calendarViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        return root
    }
}
