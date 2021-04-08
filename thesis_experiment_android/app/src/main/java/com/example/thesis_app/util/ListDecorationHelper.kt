package com.example.thesis_app.util

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.thesis_app.R
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration


object ListDecorationHelper {

    fun createHomeDecoration(context: Context): RecyclerView.ItemDecoration {
        return HorizontalDividerItemDecoration.Builder(context)
            .colorProvider{ position, recyclerView ->
                ContextCompat.getColor(context, R.color.divider_transparent)
            }
            .sizeProvider { position, recyclerView ->
                context.resources.getDimensionPixelSize(R.dimen.spacing_small)
            }
            .build()
    }

}