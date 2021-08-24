package com.example.thesis_app.ui.hoofdstuk1.viewmodel

import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.view.Menu
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider



class Hoofdstuk1ViewModel : ViewModel() {

    // region view events

    // endregion

    // region methods

    // endregion

    // region classes

    @Suppress("UNCHECKED_CAST")
    class Factory : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return Hoofdstuk1ViewModel() as T
        }
    }

    // endregion
}