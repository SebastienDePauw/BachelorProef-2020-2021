package com.example.thesis_app.ui.hoofdstuk9.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider



class Hoofdstuk9ViewModel : ViewModel() {

    // region view events

    // endregion

    // region methods

    // endregion

    // region classes

    @Suppress("UNCHECKED_CAST")
    class Factory : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return Hoofdstuk9ViewModel() as T
        }
    }

    // endregion
}