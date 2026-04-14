package com.saha.testapplication.di

import com.saha.testapplication.dependencies.MyRepository
import com.saha.testapplication.dependencies.MyRepositoryImpl
import com.saha.testapplication.dependencies.MyViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module


expect val platformModule: Module

val sharedModule = module {

    /*single {
        MyRepositoryImpl(get())
    }.bind<MyRepository>()*/

    singleOf(::MyRepositoryImpl).bind<MyRepository>()
    viewModelOf(::MyViewModel)

}