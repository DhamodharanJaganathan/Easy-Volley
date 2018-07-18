package com.dhamodharan.easyvolley;

import android.content.Context;
import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;


public class VolleyCall {

  private static final int MY_SOCKET_TIMEOUT_MS = 10000; // 10 seconds for Retry policy

  public static void getResponse(final Context context, String url, int method, HashMap<String,
      String> payload, final VolleyCallback volleyCallback) {

    JsonObjectRequest request = new JsonObjectRequest(method, url,
        new JSONObject(payload), new Response.Listener<JSONObject>() {
      @Override
      public void onResponse(JSONObject response) {

        if (response != null) {
          // Success response
          volleyCallback.onSuccessResponse(response);
        } else {
          volleyCallback.onError(null);
        }

      }
    }, new Response.ErrorListener() {
      @Override
      public void onErrorResponse(VolleyError error) {

        if (error instanceof TimeoutError || error instanceof NoConnectionError) {
          volleyCallback.onVolleyError("Timeout Error");
        } else if (error instanceof AuthFailureError) {
          volleyCallback.onVolleyError("AuthFailure Error");
        } else if (error instanceof ServerError) {
          volleyCallback.onVolleyError("Server Error");
        } else if (error instanceof NetworkError) {
          volleyCallback.onVolleyError("Network Error");
        } else if (error instanceof ParseError) {
          volleyCallback.onVolleyError("Parse Error");
        }
      }

    }
    ) {
      @Override
      public Map<String, String> getHeaders() {
        Map<String, String> params = new HashMap<>();
        //Add Header
        params.put("Content-Type", "application/json");

        return params;
      }
    };

    // RetryPolicy
    request.setRetryPolicy(
        new DefaultRetryPolicy(MY_SOCKET_TIMEOUT_MS,
            DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
            DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

    // Singleton Request Queue
    VolleySingleton.getInstance(context).getRequestQueue().add(request);
  }
}
