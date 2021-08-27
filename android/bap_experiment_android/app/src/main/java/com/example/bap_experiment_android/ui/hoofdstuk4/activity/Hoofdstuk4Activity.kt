package com.example.bap_experiment_android.ui.hoofdstuk4.activity

import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_hoofdstuk4.*
import com.example.bap_experiment_android.R
import com.example.bap_experiment_android.ui.hoofdstuk4.viewmodel.Hoofdstuk4ViewModel
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_hoofdstuk4.button6
import kotlinx.android.synthetic.main.activity_hoofdstuk4.button7_1
import kotlinx.android.synthetic.main.activity_hoofdstuk4.button7_2
import kotlinx.android.synthetic.main.activity_hoofdstuk4.button8
import kotlinx.android.synthetic.main.activity_hoofdstuk4.button9
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit


class Hoofdstuk4Activity : AppCompatActivity() {

    private lateinit var viewModel: Hoofdstuk4ViewModel

    companion object {

        fun getIntent(context: Context): Intent {
            return Intent(context, Hoofdstuk4Activity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hoofdstuk4)

        val viewModelFactory = Hoofdstuk4ViewModel.Factory()
        viewModel = ViewModelProvider(this, viewModelFactory).get(Hoofdstuk4ViewModel::class.java)
        button6.setOnClickListener { startAsyncTask() }
        button7_1.setOnClickListener { startThread() }
        button7_2.setOnClickListener { startHandler() }
        button8.setOnClickListener { startCoroutine() }
        button9.setOnClickListener { startRxJava() }
    }

    fun startAsyncTask() {
        LongRunningOperation().execute();
        for (i in 0..5) {
            Thread.sleep(500)
            Log.i("AsyncTask", "${i}")
        }
    }

    fun startCoroutine() = runBlocking {
        LongRunningOperation2()
        Log.i("Coroutine", "Done")
    }

    fun startHandler() {
        val runnable = Runnable {
            Thread.sleep(2000)
            Log.i("Handler", "After two secs")
        }

        Handler().post(runnable)

        for (i in 0..5) {
            Thread.sleep(500)
            Log.i("Handler", "${i}")
        }
        Log.i("Handler", "Done")


    }
    fun startRxJava() {
        Observable
            .interval(1, TimeUnit.SECONDS)
            .doOnNext { n -> Log.i("RxJava", "${n}") }
            .subscribe()
        Log.i("RxJava","Done")
    }

    fun startThread() {
        val runnable = Runnable {
            Thread.sleep(2000)
            Log.i("Thread", "After two secs")
        }

        Thread(runnable).start()

        for (i in 0..5) {
            Thread.sleep(500)
            Log.i("Thread", "${i}")
        }
        Log.i("Thread", "Done")
    }

    class LongRunningOperation() : AsyncTask<Void, Void, String>() {
        override fun doInBackground(vararg params: Void?): String? {
            Thread.sleep(2000)
            Log.i("AsyncTask", "After two secs")
            return "Done"
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            if (result != null) {
                Log.i("AsyncTask", result)
            }
        }
    }

    suspend fun LongRunningOperation2() = coroutineScope {
        launch {
            delay(2000)
            Log.i("Coroutine", "After two secs!")
        }
        for (i in 0..5) {
            delay(500)
            Log.i("Coroutine", "${i}")
        }
    }
}