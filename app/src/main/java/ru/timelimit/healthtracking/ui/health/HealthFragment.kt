package ru.timelimit.healthtracking.ui.health

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.timelimit.healthtracking.R


class HealthFragment : Fragment() {

    companion object {
        fun newInstance() = HealthFragment()
    }

    private lateinit var viewModel: HealthViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_health, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HealthViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
