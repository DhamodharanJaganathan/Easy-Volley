package com.dhamodharan.easyvolleyexample

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast
import butterknife.ButterKnife
import com.dhamodharan.easyvolley.InternetConnectionChecker
import com.dhamodharan.easyvolley.VolleyCall
import com.dhamodharan.easyvolley.VolleyCallback
import org.json.JSONObject
import timber.log.Timber
import java.util.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)

        // Timber Log
        Timber.tag("LifeCycles")
        Timber.d("Activity Created")


        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener { view ->
            Timber.i("fab")
            Snackbar.make(view, "Developed by DJ", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }


        val btn_click_me_1 = findViewById(R.id.button1) as Button
        // set on-click listener
        btn_click_me_1.setOnClickListener {
            // your code to perform when the user clicks on the button

            if (InternetConnectionChecker.getInstance(this).isOnline) {

                val payload = HashMap<String, String>()

                val url = "http://httpbin.org/get?param1=hello"
                VolleyCall.getResponse(this@MainActivity, url, 0, payload, object : VolleyCallback {
                    override fun onSuccessResponse(response: JSONObject) {
                        Timber.d(response.toString())
                        Toast.makeText(this@MainActivity, response.toString(), Toast.LENGTH_SHORT).show()
                    }

                    override fun onError(result: JSONObject?) {

                        Toast.makeText(this@MainActivity, "No Response from server", Toast
                                .LENGTH_SHORT).show()
                    }

                    override fun onVolleyError(error: String) {

                        Toast.makeText(this@MainActivity, error, Toast.LENGTH_SHORT).show()

                    }


                })
            } else {

                Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show()
            }


        }


        val btn_click_me_3 = findViewById(R.id.button3) as Button
        // set on-click listener
        btn_click_me_3.setOnClickListener {
            // your code to perform when the user clicks on the button
            if (InternetConnectionChecker.getInstance(this).isOnline) {

                // post data (ie: form data)
                val payload = HashMap<String, String>()
                payload["name"] = "Alif"
                payload["email"] = "http://itsalif.info"

                val url = "http://httpbin.org/put"
                VolleyCall.getResponse(this@MainActivity, url, 2, payload, object : VolleyCallback {
                    override fun onSuccessResponse(response: JSONObject) {
                        Timber.d(response.toString())
                        Toast.makeText(this@MainActivity, response.toString(), Toast.LENGTH_SHORT).show()
                    }

                    override fun onError(result: JSONObject?) {

                        Toast.makeText(this@MainActivity, "No Response from server", Toast
                                .LENGTH_SHORT).show()
                    }

                    override fun onVolleyError(error: String) {

                        Toast.makeText(this@MainActivity, error, Toast.LENGTH_SHORT).show()

                    }


                })
            } else {

                Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show()
            }


        }


        val btn_click_me_2 = findViewById(R.id.button2) as Button
        // set on-click listener
        btn_click_me_2.setOnClickListener {
            // your code to perform when the user clicks on the button
            if (InternetConnectionChecker.getInstance(this).isOnline) {

                // post data (ie: form data)
                val payload = HashMap<String, String>()
                payload["name"] = "Alif"
                payload["email"] = "http://itsalif.info"

                val url = "http://httpbin.org/post"
                VolleyCall.getResponse(this@MainActivity, url, 1, payload, object : VolleyCallback {
                    override fun onSuccessResponse(response: JSONObject) {
                        Timber.d(response.toString())
                        Toast.makeText(this@MainActivity, response.toString(), Toast.LENGTH_SHORT).show()
                    }

                    override fun onError(result: JSONObject?) {

                        Toast.makeText(this@MainActivity, "No Response from server", Toast
                                .LENGTH_SHORT).show()
                    }

                    override fun onVolleyError(error: String) {

                        Toast.makeText(this@MainActivity, error, Toast.LENGTH_SHORT).show()

                    }


                })
            } else {

                Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show()
            }

        }


        val btn_click_me_4 = findViewById(R.id.button4) as Button
        // set on-click listener
        btn_click_me_4.setOnClickListener {
            // your code to perform when the user clicks on the button
            if (InternetConnectionChecker.getInstance(this).isOnline) {

                val payload = HashMap<String, String>()

                val url = "http://httpbin.org/delete"
                VolleyCall.getResponse(this@MainActivity, url, 3, payload, object : VolleyCallback {
                    override fun onSuccessResponse(response: JSONObject) {

                        Toast.makeText(this@MainActivity, response.toString(), Toast.LENGTH_SHORT).show()
                    }

                    override fun onError(result: JSONObject?) {

                        Toast.makeText(this@MainActivity, "No Response from server", Toast
                                .LENGTH_SHORT).show()
                    }

                    override fun onVolleyError(error: String) {

                        Toast.makeText(this@MainActivity, error, Toast.LENGTH_SHORT).show()

                    }


                })
            } else {

                Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show()
            }

        }


    }

}