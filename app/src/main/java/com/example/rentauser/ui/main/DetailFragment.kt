package com.example.rentauser.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.rentauser.R
import com.example.rentauser.di.components.ViewModelComponent
import com.example.rentauser.repository.db.entity.UserEntity
import com.example.rentauser.ui.base.BaseFragment
import kotlinx.android.synthetic.main.detail_fragment.*
import javax.inject.Inject
import kotlin.properties.Delegates

/**
 * Created by Dmitriy Larin
 */
class DetailFragment  : BaseFragment() {
    @Inject
    lateinit var viewModel: MainViewModel

    private var userId by Delegates.notNull<Int>()

    override fun injectDependency(component: ViewModelComponent) {
        component.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.detail_fragment, container, false)

        userId = requireArguments().getInt("id")
        viewModel.apply {
            loadUser(userId)
            userLiveData.observe({ viewLifecycleOwner.lifecycle }, ::setView)

        }
        return view
    }

    private fun setView(user: UserEntity){
        Glide
            .with(this)
            .load(user.avatar)
            .error(R.drawable.ic_image_not_found)
            .override(200, 200)
            .centerCrop()
            .into(iv_logo)
        val fullName = "${user.firstName} ${user.lastName}"
        et_name.text = fullName
        tv_email.text = user.email
    }
}