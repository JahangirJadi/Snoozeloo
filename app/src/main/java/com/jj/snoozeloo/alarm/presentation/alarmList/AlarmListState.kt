package com.jj.snoozeloo.alarm.presentation.alarmList

import com.jj.snoozeloo.alarm.domain.Alarm

data class AlarmListState(
    val alarmList: List<Alarm> = emptyList()
)