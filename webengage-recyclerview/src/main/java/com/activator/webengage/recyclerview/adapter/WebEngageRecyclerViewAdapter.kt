package com.activator.webengage.recyclerview.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class WebEngageRecyclerViewAdapter(viewHolder: ViewHolderInterface) : RecyclerView.Adapter<ViewHolderInterface.ViewHolderObjectInterface>() {

    val viewHolderInterface : ViewHolderInterface

    init {
        viewHolderInterface = viewHolder
    }

    override fun getItemViewType(position: Int): Int {
        return viewHolderInterface.getViewType(position)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolderInterface.ViewHolderObjectInterface {
        Log.d("AppInboxViewHolder", "onCreateViewHolder ")

        return viewHolderInterface.getViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: ViewHolderInterface.ViewHolderObjectInterface, position: Int) {
        Log.d("AppInboxViewHolder", "onBindViewHolder ")

        viewHolderInterface.initViews(holder, position)
    }

    override fun getItemCount(): Int {
        return viewHolderInterface.getSize()
    }


}