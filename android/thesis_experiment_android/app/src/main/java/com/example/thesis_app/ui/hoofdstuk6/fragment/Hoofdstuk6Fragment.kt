package com.example.thesis_app.ui.hoofdstuk6.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.thesis_app.R
import com.example.thesis_app.ui.hoofdstuk6.viewmodel.Hoofdstuk6ViewModel


class Hoofdstuk6Fragment : Fragment() {

    private lateinit var viewModel: Hoofdstuk6ViewModel

    companion object {

        fun newInstance(): Hoofdstuk6Fragment {
            return Hoofdstuk6Fragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModelFactory = Hoofdstuk6ViewModel.Factory()
        viewModel = ViewModelProvider(this, viewModelFactory).get(Hoofdstuk6ViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_hoofdstuk6, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    // region ViewModel observers

    // endregion
}