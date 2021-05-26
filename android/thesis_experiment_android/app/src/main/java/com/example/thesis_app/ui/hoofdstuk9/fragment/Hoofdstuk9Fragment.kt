package com.example.thesis_app.ui.hoofdstuk9.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.thesis_app.R
import com.example.thesis_app.ui.hoofdstuk9.viewmodel.Hoofdstuk9ViewModel


class Hoofdstuk9Fragment : Fragment() {

    private lateinit var viewModel: Hoofdstuk9ViewModel

    companion object {

        fun newInstance(): Hoofdstuk9Fragment {
            return Hoofdstuk9Fragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModelFactory = Hoofdstuk9ViewModel.Factory()
        viewModel = ViewModelProvider(this, viewModelFactory).get(Hoofdstuk9ViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_hoofdstuk9, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    // region ViewModel observers

    // endregion
}