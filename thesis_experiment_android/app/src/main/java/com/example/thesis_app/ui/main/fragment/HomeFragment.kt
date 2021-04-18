package com.example.thesis_app.ui.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.thesis_app.R
import com.example.thesis_app.databinding.FragmentHomeBinding
import com.example.thesis_app.ui.main.list.MainAdapter
import com.example.thesis_app.ui.main.model.CardData
import com.example.thesis_app.ui.main.model.CardEnum
import com.example.thesis_app.ui.main.viewmodel.MainViewModel
import com.example.thesis_app.util.ListDecorationHelper

class HomeFragment: Fragment(), MainAdapter.CardListener {

    private lateinit var adapter: MainAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModelFactory = MainViewModel.Factory()
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentHomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        adapter = MainAdapter(this)
        val recyclerview = binding.recyclerViewHome
        recyclerview.adapter = adapter
        recyclerview.addItemDecoration(ListDecorationHelper.createHomeDecoration(context!!))
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.homeLiveData.observe(this){ onDataChanged(it) }

    }

    override fun cardClickListener(cardData: CardData, view: View) {
        when(cardData.cardEnum){
            CardEnum.HOOFDSTUK1 -> { view.findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToHoofdstuk1Fragment()) }
            CardEnum.HOOFDSTUK2 -> {}
            CardEnum.HOOFDSTUK3 -> {}
            CardEnum.HOOFDSTUK4 -> {}
            CardEnum.HOOFDSTUK5 -> {}
            CardEnum.HOOFDSTUK6 -> {}
            CardEnum.HOOFDSTUK7 -> {}
            CardEnum.HOOFDSTUK8 -> {}
            CardEnum.HOOFDSTUK9 -> {}
        }
    }

    private fun onDataChanged(card: List<CardData>){
        adapter.data = card
    }
}