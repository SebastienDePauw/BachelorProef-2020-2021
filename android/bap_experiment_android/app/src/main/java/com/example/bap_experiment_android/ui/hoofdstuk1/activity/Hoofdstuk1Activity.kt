package com.example.bap_experiment_android.ui.hoofdstuk1.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_hoofdstuk1.*
import com.example.bap_experiment_android.R
import com.example.bap_experiment_android.ui.hoofdstuk1.viewmodel.Hoofdstuk1ViewModel


class Hoofdstuk1Activity : AppCompatActivity() {

    private lateinit var viewModel: Hoofdstuk1ViewModel

    companion object {

        fun getIntent(context: Context): Intent {
            return Intent(context, Hoofdstuk1Activity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hoofdstuk1)

        val viewModelFactory = Hoofdstuk1ViewModel.Factory()
        viewModel = ViewModelProvider(this, viewModelFactory).get(Hoofdstuk1ViewModel::class.java)
    }

    // region ViewModel observers

    // endregion
}
