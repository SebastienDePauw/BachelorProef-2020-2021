package com.example.thesis_app.ui.hoofdstuk7.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.thesis_app.R
import com.example.thesis_app.ui.hoofdstuk7.viewmodel.Hoofdstuk7ViewModel


class Hoofdstuk7Fragment : Fragment() {

    private lateinit var viewModel: Hoofdstuk7ViewModel

    companion object {

        fun newInstance(): Hoofdstuk7Fragment {
            return Hoofdstuk7Fragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModelFactory = Hoofdstuk7ViewModel.Factory()
        viewModel = ViewModelProvider(this, viewModelFactory).get(Hoofdstuk7ViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_hoofdstuk7, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    // region ViewModel observers

    // endregion
}