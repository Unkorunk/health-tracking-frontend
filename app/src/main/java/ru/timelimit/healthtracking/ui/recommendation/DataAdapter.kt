package ru.timelimit.healthtracking.ui.recommendation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.timelimit.healthtracking.R

class DataAdapter(context: Context, cards : List<RecommendationCard>) : RecyclerView.Adapter<DataAdapter.ViewHolder>() {
    private val recommendations : List<RecommendationCard> = cards
    private val inflater : LayoutInflater? = LayoutInflater.from(context)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater!!.inflate(R.layout.recommendation_card, parent,false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return recommendations.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recommendation = recommendations[position]
        holder.authorImageView.setImageResource(recommendation.userImage)
        holder.authorView.text = recommendation.author
        holder.dateView.text = recommendation.publicationDate
        holder.postImageView.setImageResource(recommendation.recommendationImage)
        holder.titleView.text = recommendation.title
        holder.descriptionView.text = recommendation.description
    }

    class ViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        val authorImageView: ImageView = view.findViewById(R.id.author_image)
        val authorView: TextView = view.findViewById(R.id.author)
        val dateView: TextView = view.findViewById(R.id.publicationDate)
        val postImageView: ImageView = view.findViewById(R.id.posts_image)
        val titleView: TextView = view.findViewById(R.id.title)
        val descriptionView: TextView = view.findViewById(R.id.description)
    }
}