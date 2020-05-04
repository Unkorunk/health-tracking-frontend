package ru.timelimit.healthtracking.ui.recommendation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.textclassifier.TextSelection
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject
import ru.timelimit.healthtracking.GlobalStorage
import ru.timelimit.healthtracking.GlobalStorage.Companion.token
import ru.timelimit.healthtracking.R

class RecommendationFragment : Fragment() {
    private val recommendationCards : MutableList<RecommendationCard> = arrayListOf()
    private lateinit var recommendationViewModel: RecommendationViewModel
    //private var requestQueue : RequestQueue? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        recommendationViewModel =
            ViewModelProviders.of(this).get(RecommendationViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_recommendation, container, false)

        //requestQueue = Volley.newRequestQueue(this.context)

        val url = GlobalStorage.serverAddress + "feed/get?token=$token"
        val request = StringRequest(Request.Method.GET, url, Response.Listener {
            val jsonObject = JSONObject(it)
            if (jsonObject["status"] is Boolean && jsonObject["posts"] is JSONArray) {
                val status = jsonObject["status"] as Boolean
                val posts = jsonObject["posts"] as JSONArray
                if (status) {
                    for (i in 0 until posts.length()) {
                        val post = posts.get(i) as JSONObject

                        val recommendationCard = RecommendationCard()
                        recommendationCard.author = post["author_name"] as String
                        recommendationCard.description = post["description"] as String
                        recommendationCard.publicationDate = post["publication_time"] as String
                        recommendationCard.title = post["title"] as String
                        recommendationCard.recommendationImage = R.drawable.ic_home_black_24dp
                        recommendationCard.userImage = R.drawable.ic_dashboard_black_24dp
                        recommendationCards.add(recommendationCard)

                        val recyclerView = root.findViewById<RecyclerView>(R.id.recyclerview)
                        val adapter = DataAdapter(root.context, recommendationCards)
                        recyclerView.adapter = adapter
                    }
                }
            }
        }, Response.ErrorListener {
            // TODO: error
        })

        GlobalStorage.requestQueue!!.add(request)

        return root
    }
}
