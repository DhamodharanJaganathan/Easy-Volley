package com.dhamodharan.easyvolley;

import android.content.Context;
import android.widget.Toast;
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

  public static final int MY_SOCKET_TIMEOUT_MS = 10000; // 10 seconds for Retry policy

  public static void getResponse(final Context context, String url, int method, HashMap<String,
      String> payload, final VolleyCallback volleyCallback) {

    JsonObjectRequest request = new JsonObjectRequest(method, url,
        new JSONObject(payload), new Response.Listener<JSONObject>() {
      @Override
      public void onResponse(JSONObject response) {

        // Success response
        volleyCallback.onSuccessResponse(response);

      }
    }, new Response.ErrorListener() {
      @Override
      public void onErrorResponse(VolleyError error) {

        // Error response
        Message_Info(error, context, volleyCallback);
      }


    }
    ) {
      @Override
      public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> params = new HashMap<String, String>();
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


  public static void Message_Info(VolleyError error, Context context,
      VolleyCallback volleyCallback) {

    if (error instanceof NetworkError) {
      volleyCallback.verror(error);
    } else if (error instanceof ServerError) {
      // check & Test your API url
      Toast.makeText(context, "Server not found", Toast.LENGTH_SHORT).show();
    } else if (error instanceof AuthFailureError) {
      volleyCallback.verror(error);
    } else if (error instanceof ParseError) {
      volleyCallback.verror(error);
    } else if (error instanceof NoConnectionError) {
      // No internet error
      Toast.makeText(context, "No connection error", Toast.LENGTH_SHORT).show();
    } else if (error instanceof TimeoutError) {
      // Time-out error
      // Add toast here
    } else {
      volleyCallback.verror(error);
    }
  }
}
