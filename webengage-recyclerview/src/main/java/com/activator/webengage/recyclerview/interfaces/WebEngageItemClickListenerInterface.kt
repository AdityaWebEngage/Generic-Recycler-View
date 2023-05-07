package com.activator.webengage.recyclerview.interfaces

import com.webengage.notification.inbox.data.models.WEInboxData
import com.webengage.notification.inbox.data.models.WEInboxMessage

interface WebEngageItemClickListenerInterface {
    fun onItemClick(weInboxMessage: WEInboxMessage)
}