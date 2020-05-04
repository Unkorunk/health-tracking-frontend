package ru.timelimit.healthtracking

import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class GlobalStorage {
    companion object {
        lateinit var requestQueue : RequestQueue

        val serverAddress = "http://104.248.59.99:8080/"
        var token = "Emm3Eg03GZUkTCxF3iuzsnipFnc7IqcNQFk9T28frJ26PEGciPq6qV42GHFigSr0d57UFHVuw2WfhWBvmrsf6yjT5ipbzEVWNbWdlbEY2yw6mfEa7OxtjD4aZ3w7YMJl"
        var expiresIn = ""
        var isMedic = false

        @JvmStatic
        fun Auth(login : String, password : String) {
            val url = serverAddress + "account/login?login=$login&password=$password"
            val request = StringRequest(Request.Method.GET, url, Response.Listener {
                val jsonObject = JSONObject(it)
                if (jsonObject["status"] is Boolean && jsonObject["token"] is String
                    && jsonObject["expires_in"] is String && jsonObject["role"] is Boolean) {
                    val status = jsonObject["status"] as Boolean
                    val token = jsonObject["token"] as String
                    val expiresIn = jsonObject["expires_in"] as String
                    val role = jsonObject["role"] as Boolean
                    if (status) {
                        GlobalStorage.token = token
                        GlobalStorage.expiresIn = expiresIn
                        GlobalStorage.isMedic = role
                        MainActivity.Auth()
                    } else {
                        //TODO: error
                    }
                }
            }, Response.ErrorListener {
                // TODO: error
            })

            requestQueue.add(request)
        }

        fun Reg(login : String, password : String, firstName : String, secondName : String, role : Boolean) {
            val roleId = if (role) "true" else "false"

            val url = serverAddress + "account/registration?login=$login" +
                    "&password=$password" +
                    "&role=$roleId" +
                    "&firstName=$firstName" +
                    "&lastName=$secondName"
            val request = StringRequest(Request.Method.GET, url, Response.Listener {
                val jsonObject = JSONObject(it)
                if (jsonObject["status"] is Boolean) {
                    val status = jsonObject["status"] as Boolean
                    if (status) {
                        isMedic = role
                        Auth(login, password)
                    } else {
                        //TODO: error
                    }
                }
            }, Response.ErrorListener {
                // TODO: error
            })

            requestQueue.add(request)
        }
    }
}