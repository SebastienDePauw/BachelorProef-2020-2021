package com.example.bap_experiment_android.ui.hoofdstuk3.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_hoofdstuk3.*
import com.example.bap_experiment_android.R
import com.example.bap_experiment_android.ui.hoofdstuk3.viewmodel.Hoofdstuk3ViewModel


class Hoofdstuk3Activity : AppCompatActivity() {

    private lateinit var viewModel: Hoofdstuk3ViewModel

    companion object {

        fun getIntent(context: Context): Intent {
            return Intent(context, Hoofdstuk3Activity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hoofdstuk3)

        val viewModelFactory = Hoofdstuk3ViewModel.Factory()
        viewModel = ViewModelProvider(this, viewModelFactory).get(Hoofdstuk3ViewModel::class.java)
    }

    // region ViewModel observers

    // endregion
}
