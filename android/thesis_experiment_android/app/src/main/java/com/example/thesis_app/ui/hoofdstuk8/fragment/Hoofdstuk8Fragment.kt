package com.example.thesis_app.ui.hoofdstuk8.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.thesis_app.R
import com.example.thesis_app.ui.hoofdstuk8.viewmodel.Hoofdstuk8ViewModel


class Hoofdstuk8Fragment : Fragment() {

    private lateinit var viewModel: Hoofdstuk8ViewModel

    companion object {

        fun newInstance(): Hoofdstuk8Fragment {
            return Hoofdstuk8Fragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModelFactory = Hoofdstuk8ViewModel.Factory()
        viewModel = ViewModelProvider(this, viewModelFactory).get(Hoofdstuk8ViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_hoofdstuk8, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    // region ViewModel observers

    // endregion
}