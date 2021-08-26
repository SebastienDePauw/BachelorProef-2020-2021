package com.example.bap_experiment_android.ui.hoofdstuk5.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_hoofdstuk5.*
import com.example.bap_experiment_android.R
import com.example.bap_experiment_android.ui.hoofdstuk5.viewmodel.Hoofdstuk5ViewModel


class Hoofdstuk5Activity : AppCompatActivity() {

    private lateinit var viewModel: Hoofdstuk5ViewModel

    companion object {

        fun getIntent(context: Context): Intent {
            return Intent(context, Hoofdstuk5Activity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hoofdstuk5)

        val viewModelFactory = Hoofdstuk5ViewModel.Factory()
        viewModel = ViewModelProvider(this, viewModelFactory).get(Hoofdstuk5ViewModel::class.java)
    }

    // region ViewModel observers

    // endregion
}
