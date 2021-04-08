package com.example.thesis_app.ui.splash

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class SplashViewModel: ViewModel() {
    val navigationLiveData: LiveData<Navigation> get() = navigationMutableLiveData
    private val navigationMutableLiveData = MutableLiveData<Navigation>()

    val loadingLiveData: LiveData<Boolean> get() = loadingMutableLiveData
    private val loadingMutableLiveData = MutableLiveData<Boolean>()

    init {
        startCounter()
    }

    fun startCounter(){
        val timerDisposable = Completable.timer(3, TimeUnit.SECONDS) .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                loadingMutableLiveData.value = false
                navigationMutableLiveData.value = Navigation.Home
            }, {
                // Ignore errors.
            });
    }

    sealed class Navigation {
        object Home : Navigation()
    }

    class Factory : ViewModelProvider.Factory {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return SplashViewModel() as T
        }
    }
}