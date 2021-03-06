package org.kotlinacademy

import android.app.Application
import org.kotlinacademy.BuildConfig
import org.kotlinacademy.common.UI
import org.kotlinacademy.respositories.BaseURL
import kotlinx.coroutines.experimental.android.UI as AndroidUI

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        UI = AndroidUI
        BaseURL = BuildConfig.SERVER_URL
    }
}