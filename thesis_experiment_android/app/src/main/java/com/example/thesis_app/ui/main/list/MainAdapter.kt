package com.example.thesis_app.ui.main.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.thesis_app.R
import com.example.thesis_app.ui.main.model.CardData
import com.google.android.material.textview.MaterialTextView

class MainAdapter: RecyclerView.Adapter<MainAdapter.ViewHolder>() {

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
        return ViewHolder.create(parent)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        companion object {
            fun create(parent: ViewGroup): ViewHolder {
                val view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_item_home, parent, false)
                return ViewHolder(view)
            }
        }

        init {

        }

        fun bind(cardData: CardData) {
            itemView.findViewById<MaterialTextView>(R.id.title).text = cardData.title
        }
    }

}