package com.example.thesis_app.ui.hoofdstuk4.fragment

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.thesis_app.R
import com.example.thesis_app.ui.hoofdstuk4.viewmodel.Hoofdstuk4ViewModel


class Hoofdstuk4Fragment : Fragment() {

    private lateinit var viewModel: Hoofdstuk4ViewModel

    companion object {

        fun newInstance(): Hoofdstuk4Fragment {
            return Hoofdstuk4Fragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModelFactory = Hoofdstuk4ViewModel.Factory()
        viewModel = ViewModelProvider(this, viewModelFactory).get(Hoofdstuk4ViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_hoofdstuk4, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button5).setOnClickListener { click -> runnableExample() }
    }

    fun runnableExample(){
        val runnable = Runnable {
            // Long running task
        }

        Handler().post(runnable)

        Thread(runnable).start()
    }

    // region ViewModel observers

    // endregion
}