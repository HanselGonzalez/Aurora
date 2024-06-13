package com.sign.aurora.ui

import android.app.Application
import com.google.android.gms.ads.MobileAds

class AuroraApp:Application() {

    override fun onCreate() {
        super.onCreate()
        MobileAds.initialize(this)
    }
}