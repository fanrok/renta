package com.example.rentauser.ui.main.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.rentauser.R
import com.example.rentauser.repository.db.entity.UserEntity

class RecyclerViewAdapter : BaseAdapter<RecyclerView.ViewHolder>() {
    var items = emptyList<UserEntity>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    var onItemClick: ((id: Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_LOADING -> {
                val department = layoutInflater.inflate(R.layout.item_loader, parent, false)
                LoadingViewHolder(department)
            }
            else -> {
                val employee = layoutInflater.inflate(R.layout.item_user, parent, false)
                UserViewHolder(employee)
            }
        }
    }

    /**
     * Определение типа элемента
     */
    override fun getItemViewType(position: Int): Int {
        return if (items[position].id == 0) {
            VIEW_TYPE_LOADING
        } else {
            VIEW_TYPE_ELEMENT
        }
    }

    /**
     * привязка вью холдеров
     */
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == VIEW_TYPE_ELEMENT) {
            val vh = holder as UserViewHolder
            vh.bind(items[position])
        } else {
            val vh = holder as LoadingViewHolder
            vh.bind()
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    /**
     * Холдер группы
     */
    inner class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val name: TextView = view.findViewById(R.id.tv_name)
        private val clItem: ConstraintLayout = view.findViewById(R.id.cl_item)

        /**
         * Привязк аданных
         */
        fun bind(user: UserEntity) {
            clItem.setOnClickListener {
                onItemClick?.invoke(user.id)
            }
            name.text = user.firstName
        }
    }

    /**
     * Холдер элемента
     */
    inner class LoadingViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind() {}
    }

    companion object{
        private const val VIEW_TYPE_LOADING = 0
        private const val VIEW_TYPE_ELEMENT = 1
    }
}