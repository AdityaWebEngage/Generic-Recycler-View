package com.activator.appinboxrecyclerview

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.activator.webengage.recyclerview.adapter.WebEngageRecyclerViewAdapter
import com.webengage.notification.inbox.WENotificationInbox
import com.webengage.notification.inbox.callbacks.WEInboxCallback
import com.webengage.notification.inbox.data.models.WEInboxData
import com.webengage.notification.inbox.data.models.WEInboxMessage

class AppInboxFragment : Fragment(R.layout.layout_fragment_app_inbox) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.layout_fragment_app_inbox, container, false)
        initView(view)
        return view
    }

    fun initView(view: View) {
        val rv = view.findViewById<RecyclerView>(R.id.fragment_recyclerView)
        val list = mutableListOf<WEInboxMessage>()
        rv.layoutManager = LinearLayoutManager(requireContext())

        val adapter = WebEngageRecyclerViewAdapter(AppInboxViewHolder(list))
        rv.adapter = adapter
        WENotificationInbox.get(requireContext())
            .getNotificationList(requireContext(), object : WEInboxCallback<WEInboxData> {
                override fun onError(errorCode: Int, error: Map<String, Any?>) {
                    Log.d("AppInboxFragment", "onError $errorCode")
                }

                override fun onSuccess(result: WEInboxData) {
                    Log.d("AppInboxFragment", "onSuccess ${result.messageList}")
                    list.addAll(result.messageList)
                    Log.d("AppInboxFragment", "onSuccess list ${list.size}")
                    adapter.notifyDataSetChanged()
                }
            })
    }
}