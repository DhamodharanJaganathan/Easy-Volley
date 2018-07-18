package com.dhamodharan.easyvolley

import org.json.JSONObject

interface VolleyCallback {

    fun onSuccessResponse(result: JSONObject)

    fun onError(result: JSONObject?)

    fun onVolleyError(error: String)
}