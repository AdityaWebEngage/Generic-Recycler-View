package com.activator.appinboxrecyclerview

import android.app.Application
import com.google.firebase.messaging.FirebaseMessaging
import com.webengage.sdk.android.Channel
import com.webengage.sdk.android.WebEngage
import com.webengage.sdk.android.WebEngageActivityLifeCycleCallbacks
import com.webengage.sdk.android.WebEngageConfig

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        val config = WebEngageConfig.Builder()
            .setDebugMode(true)
            .setWebEngageKey("aa131d2c")
            .build()
        registerActivityLifecycleCallbacks(WebEngageActivityLifeCycleCallbacks(this, config))

        WebEngage.get().user().login("aditya.sawant")

        FirebaseMessaging.getInstance().token.addOnCompleteListener {
            if(it.isSuccessful)
                WebEngage.get().setRegistrationID(it.result)
        }

        WebEngage.get().user().setOptIn(Channel.PUSH, true)
        WebEngage.get().user().setDevicePushOptIn(true)
    }
}