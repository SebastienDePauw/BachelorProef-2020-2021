package com.example.thesis_app.ui.hoofdstuk8.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider



class Hoofdstuk8ViewModel : ViewModel() {

    // region view events

    // endregion

    // region methods

    // endregion

    // region classes

    @Suppress("UNCHECKED_CAST")
    class Factory : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return Hoofdstuk8ViewModel() as T
        }
    }

    // endregion
}