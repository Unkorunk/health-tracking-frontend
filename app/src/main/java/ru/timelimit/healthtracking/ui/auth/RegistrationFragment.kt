package ru.timelimit.healthtracking.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.navigation.fragment.NavHostFragment
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.google.android.material.textfield.TextInputEditText
import org.json.JSONObject
import ru.timelimit.healthtracking.GlobalStorage
import ru.timelimit.healthtracking.MainActivity
import ru.timelimit.healthtracking.R

/**
 * A simple [Fragment] subclass.
 * Use the [RegistrationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegistrationFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registration, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<View>(R.id.reg_reg_btn).setOnClickListener {
            tryReg()
        }
    }

    private fun tryReg() {
        val login = view!!.findViewById<TextInputEditText>(R.id.reg_login_field).text
        val password = view!!.findViewById<TextInputEditText>(R.id.reg_password_field).text
        val firstName = view!!.findViewById<TextInputEditText>(R.id.reg_firstName_field).text
        val secondName = view!!.findViewById<TextInputEditText>(R.id.reg_secondName_field).text
        val isMedic = view!!.findViewById<CheckBox>(R.id.reg_isMedic).isChecked

        GlobalStorage.Reg(login.toString(), password.toString(), firstName.toString(), secondName.toString(), isMedic)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         * @return A new instance of fragment RegistrationFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            RegistrationFragment().apply {
                arguments = Bundle().apply {}
            }
    }
}
