package com.example.thesis_app.ui.hoofdstuk2.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider



class Hoofdstuk2ViewModel : ViewModel() {

    // region view events

    // endregion

    // region methods

    // endregion

    // region classes

    @Suppress("UNCHECKED_CAST")
    class Factory : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return Hoofdstuk2ViewModel() as T
        }
    }

    // endregion
}