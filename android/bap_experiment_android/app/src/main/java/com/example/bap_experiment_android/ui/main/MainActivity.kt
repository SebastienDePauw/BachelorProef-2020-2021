package com.example.bap_experiment_android.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.bap_experiment_android.R
import com.example.bap_experiment_android.ui.hoofdstuk3.activity.Hoofdstuk3Activity
import com.example.bap_experiment_android.ui.hoofdstuk4.activity.Hoofdstuk4Activity
import com.example.bap_experiment_android.ui.hoofdstuk5.activity.Hoofdstuk5Activity
import com.example.bap_experiment_android.ui.hoofdstuk7.activity.Hoofdstuk7Activity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainAdapter.CardListener {
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = MainAdapter(this)
        val recyclerview = recyclerViewHome
        recyclerview.adapter = adapter
        adapter.data = CardEnum.values().map { CardData(it, it.title) }
    }

    override fun cardClickListener(cardData: CardData, view: View) {
        when(cardData.cardEnum){
            CardEnum.HOOFDSTUK1 -> {
            }
            CardEnum.HOOFDSTUK2 -> {  }
            CardEnum.HOOFDSTUK3 -> {
                startActivity(Hoofdstuk3Activity.getIntent(this))
            }
            CardEnum.HOOFDSTUK4 -> {
                startActivity(Hoofdstuk4Activity.getIntent(this))
            }
            CardEnum.HOOFDSTUK5 -> {
                startActivity(Hoofdstuk5Activity.getIntent(this))
            }
            CardEnum.HOOFDSTUK6 -> {  }
            CardEnum.HOOFDSTUK7 -> {
                startActivity(Hoofdstuk7Activity.getIntent(this))
            }
            CardEnum.HOOFDSTUK8 -> {  }
        }
    }
}