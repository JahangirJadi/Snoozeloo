package com.jj.snoozeloo

import android.app.Application
import com.jj.snoozeloo.alarm.di.alarmModule
import com.jj.snoozeloo.core.database.di.databaseModule
import com.jj.snoozeloo.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class SnoozeLooApp: Application() {

    override fun onCreate() {
        super.onCreate()

        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidLogger()
            androidContext(this@SnoozeLooApp)
            modules(
                appModule,
                databaseModule,
                alarmModule
            )
        }
    }

}