package com.example.thesis_app.ui.main.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.thesis_app.R
import com.example.thesis_app.ui.main.model.CardData
import com.example.thesis_app.ui.main.model.CardEnum
import com.google.android.material.textview.MaterialTextView

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
                val view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_item_home, parent, false)
                return ViewHolder(view, listener)
            }
        }

        init {

        }

        private lateinit var cardData: CardData

        fun bind(cardData: CardData) {
            this.cardData = cardData
            itemView.findViewById<MaterialTextView>(R.id.title).text = itemView.resources.getString(cardData.titleRes)
            itemView.findViewById<ConstraintLayout>(R.id.cardLayout).setOnClickListener { listener.cardClickListener(cardData) }
        }
    }

    interface CardListener{
        fun cardClickListener(cardData: CardData)
    }
}