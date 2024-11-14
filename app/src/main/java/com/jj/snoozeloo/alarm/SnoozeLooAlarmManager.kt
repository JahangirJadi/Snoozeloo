package com.jj.snoozeloo.alarm

import android.app.AlarmManager
import android.content.Context
import com.jj.snoozeloo.alarm.domain.Alarm

class SnoozeLooAlarmManager(
    private val context:Context
): AlarmScheduler {

    val alarmManager = context.getSystemService(AlarmManager::class.java)

    override fun scheduleAlarm(itemAlarm: Alarm) {

    }

    override fun cancelAlarm(itemAlarm: Alarm) {

    }
}