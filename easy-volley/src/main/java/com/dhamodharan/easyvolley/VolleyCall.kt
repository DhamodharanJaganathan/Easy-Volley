package com.dhamodharan.easyvolley

import android.content.Context
import com.android.volley.AuthFailureError
import com.android.volley.DefaultRetryPolicy
import com.android.volley.NetworkError
import com.android.volley.NoConnectionError
import com.android.volley.ParseError
import com.android.volley.Response
import com.android.volley.ServerError
import com.android.volley.TimeoutError
import com.android.volley.toolbox.JsonObjectRequest
import java.util.HashMap
import org.json.JSONObject


object VolleyCall {

    private const val MY_SOCKET_TIMEOUT_MS = 10000 // 10 seconds for Retry policy

    fun getResponse(context: Context, url: String, method: Int, payload: HashMap<String, String>, volleyCallback: VolleyCallback) {

        val request = object : JsonObjectRequest(method, url,
                JSONObject(payload), Response.Listener { response ->
            if (response != null) {
                // Success response
                volleyCallback.onSuccessResponse(response)
            } else {
                volleyCallback.onError(null)
            }
        }, Response.ErrorListener { error ->
            if (error is TimeoutError || error is NoConnectionError) {
                volleyCallback.onVolleyError("Timeout Error")
            } else if (error is AuthFailureError) {
                volleyCallback.onVolleyError("AuthFailure Error")
            } else if (error is ServerError) {
                volleyCallback.onVolleyError("Server Error")
            } else if (error is NetworkError) {
                volleyCallback.onVolleyError("Network Error")
            } else if (error is ParseError) {
                volleyCallback.onVolleyError("Parse Error")
            }
        }
        ) {
            override fun getHeaders(): Map<String, String> {
                val params = HashMap<String, String>()
                //Add Header
                params["Content-Type"] = "application/json"

                return params
            }
        }

        // RetryPolicy
        request.retryPolicy = DefaultRetryPolicy(MY_SOCKET_TIMEOUT_MS,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)

        // Singleton Request Queue
        VolleySingleton.getInstance(context).requestQueue.add(request)
    }
}
