package com.example.football7.application

import android.app.Application
import com.onesignal.OneSignal

class OneSignalApplication :Application() {

    private val ONESIGNAL_APP_ID = "1924164f-f598-495d-8d7c-8050a3f968e2"

    override fun onCreate() {
        super.onCreate()

        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONESIGNAL_APP_ID)

    }

}