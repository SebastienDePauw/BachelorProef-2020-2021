package com.example.thesis_app.ui.splash

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.thesis_app.R
import com.example.thesis_app.ui.main.activity.MainActivity

class SplashActivity: AppCompatActivity() {

    private lateinit var viewModel: SplashViewModel

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, SplashActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
        setContentView(R.layout.activity_splash)

        val viewModelFactory = SplashViewModel.Factory()
        viewModel = ViewModelProvider(this, viewModelFactory).get(SplashViewModel::class.java)

        viewModel.navigationLiveData.observe(this, { onNavigationRequested(it) })
        viewModel.loadingLiveData.observe(this, { onLoadingChanged(it) })
    }

   fun onLoadingChanged(isLoading: Boolean) {
       val progressBar = findViewById<ProgressBar>(R.id.progressLoading)
       progressBar.visibility = if(isLoading) View.VISIBLE else View.GONE
    }

    private fun onNavigationRequested(navigation: SplashViewModel.Navigation) {
        when (navigation) {
            is SplashViewModel.Navigation.Home -> {
                startActivity(MainActivity.getIntent(this))
            }
        }
    }
}