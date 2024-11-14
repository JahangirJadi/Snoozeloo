package com.jj.snoozeloo.alarm.presentation.alarmList

sealed interface AlarmListAction {

    data object OnCreateAlarm: AlarmListAction
    data class OnDeleteAlarm(val idAlarm: Int): AlarmListAction
    data class OnEditAlarm(val idAlarm: Int): AlarmListAction
    data class OnToggleAlarm(val idAlarm: Int, val isEnabled: Boolean): AlarmListAction

}