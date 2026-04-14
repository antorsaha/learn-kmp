package com.saha.testapplication.di

import com.saha.testapplication.BatteryManager
import com.saha.testapplication.dependencies.DbClient
import com.saha.testapplication.dependencies.MyViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

actual val platformModule = module {
    singleOf(::DbClient)
    singleOf(::BatteryManager)
}