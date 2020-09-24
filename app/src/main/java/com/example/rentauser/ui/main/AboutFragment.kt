package com.example.rentauser.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rentauser.R
import com.example.rentauser.di.components.ViewModelComponent
import com.example.rentauser.ui.base.BaseFragment
import javax.inject.Inject

/**
 * Created by Dmitriy Larin
 */
class AboutFragment : BaseFragment() {
    @Inject
    lateinit var viewModel: MainViewModel

    override fun injectDependency(component: ViewModelComponent) {
        component.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.about_fragment, container, false)


        return view
    }

}