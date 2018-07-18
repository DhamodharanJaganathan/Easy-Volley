package com.dhamodharan.easyvolley

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.util.Log
import java.util.Objects


class InternetConnectionChecker {
    private var connected = false

    val isOnline: Boolean
        get() {
            try {
                val connectivityManager = context!!
                        .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

                var networkInfo: NetworkInfo? = null
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
                    networkInfo = Objects.requireNonNull(connectivityManager).activeNetworkInfo
                }
                connected = networkInfo != null && networkInfo.isAvailable &&
                        networkInfo.isConnected
                return connected


            } catch (e: Exception) {
              //  println("CheckConnectivity Exception: " + e.message)
              //  Log.v("connectivity", e.toString())
            }

            return connected
        }

    companion object {

        @SuppressLint("StaticFieldLeak")
        private val instance = InternetConnectionChecker()
        @SuppressLint("StaticFieldLeak")
        private var context: Context? = null

        fun getInstance(ctx: Context): InternetConnectionChecker {
            context = ctx.applicationContext
            return instance
        }
    }
}