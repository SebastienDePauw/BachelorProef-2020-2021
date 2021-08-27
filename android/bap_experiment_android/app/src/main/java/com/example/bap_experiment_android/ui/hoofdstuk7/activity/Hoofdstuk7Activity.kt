package com.example.bap_experiment_android.ui.hoofdstuk7.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_hoofdstuk7.*
import com.example.bap_experiment_android.R

class Hoofdstuk7Activity : AppCompatActivity() {
    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, Hoofdstuk7Activity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hoofdstuk7)
        val list = Array<String>(20) { _ -> "notification" }
        notifications.adapter = ArrayAdapter<String>(this, R.layout.list_item_notification, list)
    }
}
