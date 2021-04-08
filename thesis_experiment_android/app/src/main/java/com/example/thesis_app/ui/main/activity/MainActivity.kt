package com.example.thesis_app.ui.main.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.thesis_app.R
import com.example.thesis_app.ui.main.list.MainAdapter
import com.example.thesis_app.ui.main.model.CardData
import com.example.thesis_app.ui.main.viewmodel.MainViewModel
import com.example.thesis_app.util.ListDecorationHelper

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: MainAdapter
    private lateinit var viewModel: MainViewModel

    companion object {
        fun getIntent(context: Context): Intent {
            val intent: Intent = Intent(context, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.toolbar))

        adapter = MainAdapter()
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerViewHome)
        recyclerview.adapter = adapter
        recyclerview.addItemDecoration(ListDecorationHelper.createHomeDecoration(application.baseContext))
        initDataManagers()

        setData()
    }

    private fun setData(){
        adapter.data = listOf(CardData("test"), CardData("test"), CardData("test"))
    }

    private fun initDataManagers() {
        /*ResourceProvider.init(this)
        PreferencesHelper.init(this)
        DatabaseManager.init(this)
        DataManager.init(this)*/
    }
}