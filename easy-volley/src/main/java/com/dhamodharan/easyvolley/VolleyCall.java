package com.dhamodharan.easyvolley;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;


public class VolleyCall {



    public static void getResponse(final Context context, String url, String method, HashMap<String, String> payload, final VolleyCallback volleyCallback) {

        String grade = method;

        switch (grade) {

            case "POST":
                RequestQueue requester = Volley.newRequestQueue(context);
                JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, new JSONObject(payload), new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        volleyCallback.onSuccessResponse(response);

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        volleyCallback.verror(error);
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
                requester.add(request);

                break;


            case "GET":

                RequestQueue requester1 = Volley.newRequestQueue(context);
                JsonObjectRequest request1 = new JsonObjectRequest(Request.Method.GET, url, new JSONObject(payload), new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        volleyCallback.onSuccessResponse(response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        volleyCallback.verror(error);
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
                requester1.add(request1);

                break;


            case "PUT":
                RequestQueue requester2 = Volley.newRequestQueue(context);
                JsonObjectRequest request2 = new JsonObjectRequest(Request.Method.PUT, url, new JSONObject(payload), new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        volleyCallback.onSuccessResponse(response);

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        volleyCallback.verror(error);
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
                requester2.add(request2);

                break;


            case "DELETE":

                RequestQueue requester3 = Volley.newRequestQueue(context);
                JsonObjectRequest request3 = new JsonObjectRequest(Request.Method.DELETE, url, new JSONObject(payload), new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        volleyCallback.onSuccessResponse(response);

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        volleyCallback.verror(error);
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
                requester3.add(request3);

                break;

            default:
                System.out.println("Invalid grade");
        }

    }
}
