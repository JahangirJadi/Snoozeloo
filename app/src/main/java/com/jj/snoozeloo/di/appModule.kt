package com.jj.snoozeloo.di

import android.content.SharedPreferences
import com.jj.snoozeloo.MainViewModel
import com.jj.snoozeloo.SnoozeLooApp
import kotlinx.coroutines.CoroutineScope
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {

//
//    single<CoroutineScope>{
//        (androidApplication() as SnoozeLooApp).applicationScope
//    }

    viewModelOf(::MainViewModel)

}