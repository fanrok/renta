package com.example.rentauser.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rentauser.R
import com.example.rentauser.di.components.ViewModelComponent
import com.example.rentauser.repository.db.entity.UserEntity
import com.example.rentauser.ui.base.BaseFragment
import com.example.rentauser.ui.main.adapter.RecyclerViewAdapter
import javax.inject.Inject

class ListFragment : BaseFragment() {
    @Inject
    lateinit var viewModel: MainViewModel

    private lateinit var recycler: RecyclerView
    private val adapterRV = RecyclerViewAdapter()

    override fun injectDependency(component: ViewModelComponent) {
        component.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.list_fragment, container, false)

        viewModel.apply {
            liveDataAllUsers.observe({ viewLifecycleOwner.lifecycle }, ::setRecyclerItems)
            errorLiveData.observe({ viewLifecycleOwner.lifecycle }, ::showError)

        }
        recycler = view.findViewById<RecyclerView>(R.id.rv_list).apply {
            adapter = adapterRV
            layoutManager = LinearLayoutManager(context)
        }
        adapterRV.onItemClick = {navigateToDetail(it) }
        return view
    }

    private fun showError(s: String?) {
        if(!s.isNullOrEmpty()){
            Toast.makeText(context, s, Toast.LENGTH_LONG).show()
            viewModel.errorLiveData.value = ""
        }

    }
    private fun navigateToDetail(id: Int) {
        val bundle = Bundle()
        bundle.putInt("id", id)
        findNavController().navigate(R.id.action_listFragment_to_detailFragment, bundle)
    }

    private fun setRecyclerItems(items: List<UserEntity>){
        adapterRV.items = items
    }


}