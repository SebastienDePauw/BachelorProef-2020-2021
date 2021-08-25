package com.example.bap_experiment_android.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.bap_experiment_android.R

class MainAdapter(private val listener: CardListener): RecyclerView.Adapter<MainAdapter.ViewHolder>() {

        var data = listOf<CardData>()
            set(value) {
                field = value
                notifyDataSetChanged()
            }

        override fun getItemCount() = data.size

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(data[position])
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder.create(parent, listener)
        }

        class ViewHolder(itemView: View, private val listener: CardListener) : RecyclerView.ViewHolder(itemView){
            companion object {
                fun create(parent: ViewGroup, listener: CardListener): ViewHolder {
                    val view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_item_main, parent, false)
                    return ViewHolder(view, listener)
                }
            }

            init {

            }

            private lateinit var cardData: CardData

            fun bind(cardData: CardData) {
                this.cardData = cardData
                itemView.findViewById<TextView>(R.id.title).text = cardData.title
                itemView.findViewById<ConstraintLayout>(R.id.cardLayout).setOnClickListener { listener.cardClickListener(cardData, it) }
            }
        }

        interface CardListener{
            fun cardClickListener(cardData: CardData, view: View)
        }
}