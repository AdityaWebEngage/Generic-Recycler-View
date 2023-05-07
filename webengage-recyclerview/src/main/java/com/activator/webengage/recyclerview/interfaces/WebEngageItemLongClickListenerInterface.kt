package com.activator.webengage.recyclerview.interfaces

import com.webengage.notification.inbox.data.models.WEInboxMessage

interface WebEngageItemLongClickListenerInterface {
    fun onItemLongClick(weInboxMessage: WEInboxMessage)
}