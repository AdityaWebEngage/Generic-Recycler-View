package com.activator.webengage.recyclerview.interfaces

import com.webengage.notification.inbox.data.models.WEInboxMessage

interface WebEngageItemSwipeListenerInterface {
    fun onItemLeftSwipe(weInboxMessage: WEInboxMessage)

    fun onItemRightSwipe(weInboxMessage: WEInboxMessage)
}