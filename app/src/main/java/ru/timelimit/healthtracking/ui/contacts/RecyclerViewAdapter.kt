package ru.timelimit.healthtracking.ui.contacts

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView
import ru.timelimit.healthtracking.R

class RecyclerViewAdapter(imageNames : ArrayList<String>, images : ArrayList<String>, context: Context) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    private val TAG : String = "RecyclerViewAdapter"

    private val mImagesNames = imageNames
    private val mImages = images
    private val mContext = context


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image : CircleImageView = itemView.findViewById(R.id.contact_image)
        val name : TextView = itemView.findViewById(R.id.contact_name)
        val contactLayout : RelativeLayout = itemView.findViewById(R.id.contact_layout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_contacts_listitem, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mImagesNames.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder: called.")

        Glide.with(mContext).asBitmap().load(mImages[position]).into(holder.image)
        holder.name.text = mImagesNames[position]

        holder.contactLayout.setOnClickListener {
            fun onClick(view : View) {
                Log.d(TAG, "OnClick: clicked on: " + mImagesNames[position])
                Toast.makeText(mContext, mImagesNames[position], Toast.LENGTH_SHORT).show()
            }
        }
    }
}