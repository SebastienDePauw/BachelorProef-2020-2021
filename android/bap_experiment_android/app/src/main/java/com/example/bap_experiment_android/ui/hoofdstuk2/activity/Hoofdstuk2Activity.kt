package com.example.bap_experiment_android.ui.hoofdstuk2.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_hoofdstuk2.*
import com.example.bap_experiment_android.R
import com.example.bap_experiment_android.ui.hoofdstuk2.viewmodel.Hoofdstuk2ViewModel


class Hoofdstuk2Activity : AppCompatActivity() {

    private lateinit var viewModel: Hoofdstuk2ViewModel

    companion object {

        fun getIntent(context: Context): Intent {
            return Intent(context, Hoofdstuk2Activity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hoofdstuk2)

        val viewModelFactory = Hoofdstuk2ViewModel.Factory()
        viewModel = ViewModelProvider(this, viewModelFactory).get(Hoofdstuk2ViewModel::class.java)
    }

    // region ViewModel observers

    // endregion
}
