package ru.timelimit.healthtracking

import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

class GlobalStorage {
    companion object {
        lateinit var requestQueue : RequestQueue

        val serverAddress = "http://104.248.59.99:8080/"
        var token = "Emm3Eg03GZUkTCxF3iuzsnipFnc7IqcNQFk9T28frJ26PEGciPq6qV42GHFigSr0d57UFHVuw2WfhWBvmrsf6yjT5ipbzEVWNbWdlbEY2yw6mfEa7OxtjD4aZ3w7YMJl"
        var expiresIn = ""
    }
}