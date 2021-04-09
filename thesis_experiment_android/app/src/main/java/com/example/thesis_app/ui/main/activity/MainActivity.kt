package com.example.thesis_app.ui.main.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.thesis_app.R
import com.example.thesis_app.ui.main.list.MainAdapter
import com.example.thesis_app.ui.main.model.CardData
import com.example.thesis_app.ui.main.model.CardEnum
import com.example.thesis_app.ui.main.viewmodel.MainViewModel
import com.example.thesis_app.util.ListDecorationHelper

class MainActivity : AppCompatActivity(), MainAdapter.CardListener {

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

        val viewModelFactory = MainViewModel.Factory()
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        viewModel.homeLiveData.observe(this){ onDataChanged(it) }

        adapter = MainAdapter(this)
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerViewHome)
        recyclerview.adapter = adapter
        recyclerview.addItemDecoration(ListDecorationHelper.createHomeDecoration(application.baseContext))
        initDataManagers()
    }

    private fun onDataChanged(card: List<CardData>){
        adapter.data = card
    }

    private fun initDataManagers() {
        /*ResourceProvider.init(this)
        PreferencesHelper.init(this)
        DatabaseManager.init(this)
        DataManager.init(this)*/
    }

    override fun cardClickListener(cardData: CardData) {
        when(cardData.cardEnum){
            CardEnum.HOOFDSTUK1 -> {}
            CardEnum.HOOFDSTUK2 -> {}
            CardEnum.HOOFDSTUK3 -> {}
            CardEnum.HOOFDSTUK4 -> {}
            CardEnum.HOOFDSTUK5 -> {}
            CardEnum.HOOFDSTUK6 -> {}
            CardEnum.HOOFDSTUK7 -> {}
            CardEnum.HOOFDSTUK8 -> {}
            CardEnum.HOOFDSTUK9 -> {}
        }
    }
}