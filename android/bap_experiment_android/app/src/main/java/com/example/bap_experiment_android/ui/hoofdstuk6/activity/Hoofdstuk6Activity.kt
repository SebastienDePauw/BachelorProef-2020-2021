package com.example.bap_experiment_android.ui.hoofdstuk6.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_hoofdstuk6.*
import com.example.bap_experiment_android.R
import com.example.bap_experiment_android.ui.hoofdstuk6.viewmodel.Hoofdstuk6ViewModel


class Hoofdstuk6Activity : Activity() {

    private lateinit var viewModel: Hoofdstuk6ViewModel

    companion object {

        fun getIntent(context: Context): Intent {
            return Intent(context, Hoofdstuk6Activity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hoofdstuk6)

        val viewModelFactory = Hoofdstuk6ViewModel.Factory()
        //viewModel = ViewModelProvider(this, viewModelFactory).get(Hoofdstuk6ViewModel::class.java)

    }

    // region ViewModel observers

    // endregion
}
