package com.example.thesis_app.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.thesis_app.ui.main.model.CardData
import com.example.thesis_app.ui.main.model.CardEnum

class MainViewModel: ViewModel() {

    val loadingLiveData: LiveData<Boolean> get() = loadingMutableLiveData
    private val loadingMutableLiveData = MutableLiveData<Boolean>()

    val homeLiveData: LiveData<List<CardData>> get() = homeMutableLiveData
    private val homeMutableLiveData = MutableLiveData<List<CardData>>()

    init {
        getData()
        /*ResourceProvider.init(this)
        PreferencesHelper.init(this)
        DatabaseManager.init(this)
        DataManager.init(this)*/
    }

    private fun initDataManagers() {

    }

    fun getData(){
        homeMutableLiveData.value = CardEnum.values().map { CardData(it, it.titleRes) }
    }

    class Factory : ViewModelProvider.Factory {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MainViewModel() as T
        }
    }

}