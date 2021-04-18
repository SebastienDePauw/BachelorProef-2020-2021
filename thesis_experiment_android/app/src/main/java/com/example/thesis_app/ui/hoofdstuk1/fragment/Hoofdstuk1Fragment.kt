package com.example.thesis_app.ui.hoofdstuk1.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.thesis_app.R
import com.example.thesis_app.ui.hoofdstuk1.viewmodel.Hoofdstuk1ViewModel


class Hoofdstuk1Fragment : Fragment() {

    private lateinit var viewModel: Hoofdstuk1ViewModel

    companion object {

        fun newInstance(): Hoofdstuk1Fragment {
            return Hoofdstuk1Fragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModelFactory = Hoofdstuk1ViewModel.Factory()
        viewModel = ViewModelProvider(this, viewModelFactory).get(Hoofdstuk1ViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_hoofdstuk1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    // region ViewModel observers

    // endregion
}