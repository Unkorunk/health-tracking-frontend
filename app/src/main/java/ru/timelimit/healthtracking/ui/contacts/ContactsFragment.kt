package ru.timelimit.healthtracking.ui.contacts

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_contacts.*
import kotlinx.android.synthetic.main.layout_contacts_listitem.*
import ru.timelimit.healthtracking.R

class ContactsFragment : Fragment() {

    private lateinit var contactsViewModel: ContactsViewModel

    var TAG = "ContactsFragment"
    private var mNames = ArrayList<String>()
    private var mImageUrls = ArrayList<String>()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        var root = inflater.inflate(R.layout.fragment_contacts, container, false)
        initImageBitmaps()
        //initRecycleView()

        //val context : Context = this.context ?: return


        //contactsViewModel =
        //        ViewModelProviders.of(this).get(ContactsViewModel::class.java)
        //val textView: TextView = root.findViewById(R.id.text_contacts)
        //contactsViewModel.text.observe(viewLifecycleOwner, Observer {
        //    textView.text = it
        //})
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            contacts_recycler_view.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = RecyclerViewAdapter(mNames, mImageUrls, context!!)
        }

    }

    private fun initImageBitmaps() {
        Log.d(TAG, "initImageBitmaps: called.")

        mImageUrls.add("https://icons.iconarchive.com/icons/pelfusion/long-shadow-media/512/Contact-icon.png")
        mNames.add("SKORAYA POMOSH")

        mImageUrls.add("https://icons.iconarchive.com/icons/pelfusion/long-shadow-media/512/Contact-icon.png")
        mNames.add("Сексуальная помощь")
    }

    private fun initRecycleView() {

    }
}
