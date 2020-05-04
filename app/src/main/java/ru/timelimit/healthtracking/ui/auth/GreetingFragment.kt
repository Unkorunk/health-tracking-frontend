package ru.timelimit.healthtracking.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import ru.timelimit.healthtracking.R


/**
 * A simple [Fragment] subclass.
 * Use the [GreetingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GreetingFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_greeting, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<View>(R.id.auth_btn).setOnClickListener {
            val action = GreetingFragmentDirections.actionToAuth()
            NavHostFragment.findNavController(this@GreetingFragment)
                    .navigate(action)
        }

        view.findViewById<View>(R.id.register_btn).setOnClickListener {
            val action = GreetingFragmentDirections.actionToReg()
            NavHostFragment.findNavController(this@GreetingFragment)
                .navigate(action)
        }
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         * @return A new instance of fragment GreetingFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            GreetingFragment().apply {
                arguments = Bundle().apply {}
            }
    }
}
