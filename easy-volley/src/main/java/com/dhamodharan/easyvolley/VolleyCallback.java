package com.dhamodharan.easyvolley;

import com.android.volley.VolleyError;

import org.json.JSONObject;

public interface VolleyCallback {

    void onSuccessResponse(JSONObject result);

    void verror(VolleyError error);
}