package com.example.bap_experiment_android.ui.hoofdstuk5.activity

import android.content.Context
import android.content.Intent
import android.net.wifi.WifiConfiguration.AuthAlgorithm.strings
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.example.bap_experiment_android.R
import com.example.bap_experiment_android.ui.hoofdstuk5.viewmodel.Hoofdstuk5ViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_hoofdstuk5.*
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.BufferedInputStream
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import retrofit2.Retrofit
import java.io.IOException
import java.io.InputStreamReader
import android.os.AsyncTask
import android.util.Log
import com.android.volley.toolbox.JsonObjectRequest
import okhttp3.Call
import okhttp3.Callback
import org.json.JSONException
import java.io.BufferedReader
import java.lang.Exception
import java.net.MalformedURLException


class Hoofdstuk5Activity : AppCompatActivity() {

    private lateinit var viewModel: Hoofdstuk5ViewModel

    companion object {

        fun getIntent(context: Context): Intent {
            return Intent(context, Hoofdstuk5Activity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hoofdstuk5)

        val viewModelFactory = Hoofdstuk5ViewModel.Factory()
        viewModel = ViewModelProvider(this, viewModelFactory).get(Hoofdstuk5ViewModel::class.java)

        button10.setOnClickListener { startHttpUrl() }
        button11.setOnClickListener { startOKHTTP() }
        button12.setOnClickListener { startVolley() }
        button13.setOnClickListener { startRetro() }
        button14.setOnClickListener { startPic() }
        button15.setOnClickListener { startGl() }
    }

    fun startGl(){
        val url = "https://source.unsplash.com/random?sig=0"
        Glide.with(this)
            .load(url)
            .centerCrop()
            .into(imageView)
    }

    fun startHttpUrl() {
        val url: URL
        var urlConnection: HttpURLConnection? = null
        try {
            url = URL("http://www.android.com/")
            urlConnection = url
                .openConnection() as HttpURLConnection
            val `in` = urlConnection!!.inputStream
            val isw = InputStreamReader(`in`)
            var data = isw.read()
            while (data != -1) {
                val current = data.toChar()
                data = isw.read()
                Log.i("i", current.toString())
            }
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            urlConnection?.disconnect()
        }
    }

    fun startOKHTTP(){
        val client = OkHttpClient()
        val request = Request.Builder()
            .url("http://publicobject.com/helloworld.txt")
            .build()

        with(client) {

            newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    e.printStackTrace()
                }

                override fun onResponse(call: Call, response:okhttp3.Response) {
                    response.use {
                        if (!response.isSuccessful) throw IOException("Unexpected code $response")

                        for ((name, value) in response.headers) {
                            Log.i("test", "${name} + ${value}")
                        }

                        Log.i("test", "${response.body.toString()}")
                    }
                }
            })
        }

    }

    fun startPic(){
        val imageUri = "https://source.unsplash.com/random?sig=0"
        Picasso.get().load(imageUri).into(imageView)
    }
    fun startRetro(){

    }
    fun startVolley(){
        val requestQueue = Volley.newRequestQueue(this)
        val url = "https://api.myjson.com/bins/xbspb"
        val request = JsonObjectRequest(com.android.volley.Request.Method.GET, url, null, Response.Listener {
                response ->try {
            val jsonArray = response.getJSONArray("employees")
            for (i in 0 until jsonArray.length()) {
                val employee = jsonArray.getJSONObject(i)
                val firstName = employee.getString("firstname")
                val age = employee.getInt("age")
                val mail = employee.getString("mail")
                Log.i("test","$firstName, $age, $mail\n\n")
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        }, Response.ErrorListener { error -> error.printStackTrace() })
        requestQueue?.add(request)
    }


    data class User (val name: String)
}



