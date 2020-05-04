package ru.timelimit.healthtracking.ui.recommendation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import ru.timelimit.healthtracking.R

class RecommendationFragment : Fragment() {
    private val recommendationCards : MutableList<RecommendationCard> = arrayListOf()
    private lateinit var recommendationViewModel: RecommendationViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        recommendationViewModel =
            ViewModelProviders.of(this).get(RecommendationViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_recommendation, container, false)
        //todo getData from backend ASync recommended
        val recommendationCard = RecommendationCard()
        recommendationCard.author = "Ya"
        recommendationCard.description = "Pizdato"
        recommendationCard.publicationDate = "Nu ohyet mne uhe 2000 let"
        recommendationCard.title = "Nu zdarova"
        recommendationCard.recommendationImage = R.drawable.ic_home_black_24dp
        recommendationCard.userImage = R.drawable.ic_dashboard_black_24dp
        recommendationCards.add(recommendationCard)
        recommendationCards.add(recommendationCard)
        recommendationCards.add(recommendationCard)
        val recyclerView = root.findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = DataAdapter(root.context, recommendationCards)
        recyclerView.adapter = adapter
        return root
    }
}
