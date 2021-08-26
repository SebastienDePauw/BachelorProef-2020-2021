package com.example.bap_experiment_android.ui.hoofdstuk8.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_hoofdstuk8.*
import com.example.bap_experiment_android.R
import com.example.bap_experiment_android.ui.hoofdstuk8.viewmodel.Hoofdstuk8ViewModel


class Hoofdstuk8Activity : AppCompatActivity() {

    private lateinit var viewModel: Hoofdstuk8ViewModel

    companion object {

        fun getIntent(context: Context): Intent {
            return Intent(context, Hoofdstuk8Activity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hoofdstuk8)

        val viewModelFactory = Hoofdstuk8ViewModel.Factory()
        viewModel = ViewModelProvider(this, viewModelFactory).get(Hoofdstuk8ViewModel::class.java)

    }

    // region ViewModel observers

    // endregion
}
