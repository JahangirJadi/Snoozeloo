package com.jj.snoozeloo.alarm.di

import com.jj.snoozeloo.alarm.presentation.AppPlayer
import com.jj.snoozeloo.alarm.presentation.AppRingtoneManager
import com.jj.snoozeloo.alarm.presentation.RingtonePlayer
import com.jj.snoozeloo.alarm.presentation.SnoozeLooAppRingtoneManager
import com.jj.snoozeloo.alarm.presentation.alarmList.MyAlarmListViewModel
import com.jj.snoozeloo.alarm.presentation.setAlarm.SetAlarmViewModel
import com.jj.snoozeloo.alarm.presentation.ringtoneSetting.RingtoneSettingViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val alarmModule = module {

    viewModelOf(::MyAlarmListViewModel)
    viewModelOf(::SetAlarmViewModel)
    viewModelOf(::RingtoneSettingViewModel)

    singleOf(::SnoozeLooAppRingtoneManager).bind<AppRingtoneManager>()
    singleOf(::AppPlayer).bind<RingtonePlayer>()
    singleOf(::SnoozeLooAppRingtoneManager)


}