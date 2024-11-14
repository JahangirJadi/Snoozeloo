package com.jj.snoozeloo.core.database.di

import androidx.room.Room
import com.jj.snoozeloo.alarm.data.AlarmRepository
import com.jj.snoozeloo.alarm.domain.LocalAlarmDatasource
import com.jj.snoozeloo.core.database.AlarmDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            AlarmDatabase::class.java,
            "alarm.db"
        ).build()
    }

    single {
        get<AlarmDatabase>().alarmDao
    }

    singleOf(::AlarmRepository).bind<LocalAlarmDatasource>()

}