package com.example.bap_experiment_android.ui.hoofdstuk5.activity

import android.content.Context
import android.content.Intent
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

    fun startHttpUrl(){
        val url = URL("http://www.android.com/")
        val urlConnection: HttpURLConnection
                = url.openConnection() as HttpURLConnection
        try {
            val inp: InputStream
                    = BufferedInputStream(urlConnection.getInputStream())
        } finally {
            urlConnection.disconnect()
        }
    }

    fun startOKHTTP(){
        val client = OkHttpClient()
        val url = URL("http://www.android.com/")


            val request = Request.Builder()
                .url(url)
                .build()

            client.newCall(request).execute().use { response ->
                if (!response.isSuccessful)
                    throw IOException("Unexpected code $response")
                //Do something with response
            }

    }

    fun startPic(){
        val imageUri = "https://source.unsplash.com/random?sig=0"
        Picasso.get().load(imageUri).into(imageView)
    }
    fun startRetro(){

    }
    fun startVolley(){
        val queue = Volley.newRequestQueue(this)
        val url = "http://www.android.com/"

        val stringRequest = StringRequest(com.android.volley.Request.Method.GET, url,
            Response.Listener<String> { response ->
                //Do something with response
            },
            Response.ErrorListener {
                //Do something with error
            })
        queue.add(stringRequest)
    }

    data class User (val name: String)

}



