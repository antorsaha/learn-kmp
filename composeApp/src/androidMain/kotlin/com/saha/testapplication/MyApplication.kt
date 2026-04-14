package com.saha.testapplication

import android.app.Application
import com.saha.testapplication.di.initKoin
import org.koin.android.ext.koin.androidContext

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin{
            androidContext(this@MyApplication)
        }
    }
}