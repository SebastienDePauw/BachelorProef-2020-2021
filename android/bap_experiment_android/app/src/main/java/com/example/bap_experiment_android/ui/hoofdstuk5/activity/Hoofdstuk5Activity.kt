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
import com.google.gson.annotations.SerializedName
import okhttp3.Call
import okhttp3.Callback
import org.json.JSONException
import retrofit2.converter.gson.GsonConverterFactory
import java.io.BufferedReader
import java.lang.Exception
import java.net.MalformedURLException
import retrofit2.http.GET
import android.os.StrictMode







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

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
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
            url = URL("https://publicobject.com/helloworld.txt")
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
            .url("https://publicobject.com/helloworld.txt")
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

                        Log.i("test", response.body.toString())
                    }
                }
            })
        }
    }

    fun startPic(){
        val imageUri = "https://source.unsplash.com/random?sig=0"
        Picasso.get().load(imageUri).into(imageView)
    }

    fun startVolley(){
        val requestQueue = Volley.newRequestQueue(this)
        val url = "https://jsonplaceholder.typicode.com/users"
        val request = JsonObjectRequest(com.android.volley.Request.Method.GET, url, null, {
                response ->try {
            val jsonArray = response.getJSONArray("users")
            for (i in 0 until jsonArray.length()) {
                val user = jsonArray.getJSONObject(i)
                val firstName = user.getString("name")
                val age = user.getInt("username")
                val mail = user.getString("email")
                Log.i("test","$firstName, $age, $mail\n\n")
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        }, { error -> error.printStackTrace() })
        requestQueue?.add(request)
    }

    fun startRetro(){
        val retrofit= Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/").addConverterFactory(GsonConverterFactory.create()).build()
        val api = retrofit.create(api::class.java)
        val call: retrofit2.Call<List<User>> = api.get()
        Log.i("test", call.execute().message())
    }

    data class User(
        @SerializedName("name")
        val name: String
    )

    public interface api{
        @GET("users")
        fun get(): retrofit2.Call<List<User>>
    }
}



