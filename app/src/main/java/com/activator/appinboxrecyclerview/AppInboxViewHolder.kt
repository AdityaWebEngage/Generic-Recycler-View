package com.activator.appinboxrecyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.activator.webengage.recyclerview.adapter.ViewHolderInterface
import com.webengage.notification.inbox.WENotificationInbox
import com.webengage.notification.inbox.data.models.PushNotificationTemplateData
import com.webengage.notification.inbox.data.models.WEInboxMessage
import com.webengage.sdk.android.utils.htmlspanner.WEHtmlParserInterface

class AppInboxViewHolder(list: List<WEInboxMessage>) : ViewHolderInterface(list) {

    val list = list

    override fun initViews(holder: ViewHolderObjectInterface, position: Int) {
        Log.d("AppInboxViewHolder", "initViews posi $position")
        Log.d("AppInboxViewHolder", "initViews type ${getViewType(position)}")
        if (getViewType(position) == 0) {
            val pushNotificationTemplateData =
                list.get(position).message as PushNotificationTemplateData
            holder as ViewHolderObject
            holder.textView1.text =
                WEHtmlParserInterface().fromHtml(pushNotificationTemplateData.title)
            holder.textView2.text = ("Text View 2")
            holder.textView3.text = ("Text View 3")
        }

        holder.itemView.setOnClickListener(View.OnClickListener {
            onClick(position)
        })
        holder.itemView.setOnLongClickListener(View.OnLongClickListener {
            onLongClick(position)
            true
        })

    }

    override fun onClick(position : Int) {
        Log.d("AppInboxViewHolder", "onClick $position")
    }

    override fun onLongClick(position: Int) {
        Log.d("AppInboxViewHolder", "onLongClick $position")
    }

    override fun getViewType(position: Int): Int {
        if (list.get(position).channelType.equals(
                WENotificationInbox.CHANNEL.PUSH_NOTIFICATION.name, true
            )
        ) return 0
        else return 1
    }

    override fun getLayout(viewType: Int): Int {
        return if (viewType == 0) R.layout.layout_item
        else R.layout.layout_item
    }

    override fun getSize(): Int {
        Log.d("AppInboxViewHolder", "getSize ${list.size}")
        return list.size
    }

    override fun getViewHolder(parent: ViewGroup, type: Int): ViewHolderObjectInterface {
        Log.d("AppInboxViewHolder", "getViewHolder ")

        return if (type == 0) ViewHolderObject(
            LayoutInflater.from(parent.context).inflate(getLayout(type), parent, false)
        )
        else ViewHolderObject(
            LayoutInflater.from(parent.context).inflate(getLayout(type), parent, false)
        )
    }

    class ViewHolderObject(itemView: View) : ViewHolderObjectInterface(itemView) {
        val textView1 = itemView.findViewById<TextView>(R.id.item_tv1)
        val textView2 = itemView.findViewById<TextView>(R.id.item_tv2)
        val textView3 = itemView.findViewById<TextView>(R.id.item_tv3)
    }

}