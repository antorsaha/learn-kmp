package com.saha.testapplication

import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import com.saha.testapplication.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App(
    /*batteryManager = remember {
        BatteryManager()
    }*/
) }