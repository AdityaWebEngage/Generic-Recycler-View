package com.activator.webengage.recyclerview.adapter

import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.RecyclerView.ViewHolder

abstract class ViewHolderInterface(list: List<Any>) {

    abstract fun initViews(holder: ViewHolderObjectInterface, position: Int)

    abstract fun onClick(position: Int)

    abstract fun onLongClick(position: Int)

    abstract fun getViewType(position: Int): Int

    abstract fun getLayout(viewType: Int): Int

    abstract fun getSize(): Int

    abstract fun getViewHolder(parent: ViewGroup, type: Int) : ViewHolderObjectInterface

    open class ViewHolderObjectInterface(itemView: View) : ViewHolder(itemView)
}