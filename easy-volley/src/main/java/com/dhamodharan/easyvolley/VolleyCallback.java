package com.dhamodharan.easyvolley;

import org.json.JSONObject;

public interface VolleyCallback {

  void onSuccessResponse(JSONObject result);

  void onError(JSONObject result);

  void onVolleyError(String error);
}