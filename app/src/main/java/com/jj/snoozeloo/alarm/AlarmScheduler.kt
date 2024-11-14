package com.jj.snoozeloo.alarm

import com.jj.snoozeloo.alarm.domain.Alarm

interface AlarmScheduler {

    fun scheduleAlarm(itemAlarm: Alarm)
    fun cancelAlarm(itemAlarm: Alarm)

}