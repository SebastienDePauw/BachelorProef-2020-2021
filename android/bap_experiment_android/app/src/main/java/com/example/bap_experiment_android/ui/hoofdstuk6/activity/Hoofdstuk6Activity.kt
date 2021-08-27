package com.example.bap_experiment_android.ui.hoofdstuk6.activity

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_hoofdstuk6.*
import com.example.bap_experiment_android.R
import com.example.bap_experiment_android.ui.hoofdstuk6.viewmodel.Hoofdstuk6ViewModel
import android.widget.Toast

import com.example.bap_experiment_android.ui.main.MainActivity

import androidx.core.app.ActivityCompat


class Hoofdstuk6Activity : AppCompatActivity() {

    private lateinit var viewModel: Hoofdstuk6ViewModel
    private val MY_CAMERA_REQUEST_CODE = 100

    companion object {

        fun getIntent(context: Context): Intent {
            return Intent(context, Hoofdstuk6Activity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hoofdstuk6)

        val viewModelFactory = Hoofdstuk6ViewModel.Factory()
        viewModel = ViewModelProvider(this, viewModelFactory).get(Hoofdstuk6ViewModel::class.java)

        camera.setOnClickListener { checkPermission() }
    }

    fun checkPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
            == PackageManager.PERMISSION_DENIED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.CAMERA),
                MY_CAMERA_REQUEST_CODE
            );
        } else {
            Toast.makeText(this, "Permission already granted", Toast.LENGTH_SHORT)
                .show()
        }
    }
}
