package com.jj.snoozeloo.alarm.presentation.setAlarm

sealed interface SetAlarmAction {
    data class OnSelectRingtone(val ringtone: String) : SetAlarmAction
    data class OnSetVolume(val volume: Int) : SetAlarmAction
    data class OnUpdateSelectedDays(val updatedDays: Set<String>) : SetAlarmAction
    data class OnToggleVibration(val shouldVibrate: Boolean) : SetAlarmAction
    data class OnUpdateHour(val hour:Int) : SetAlarmAction
    data class OnUpdateMinute(val minute:Int) : SetAlarmAction

    data class OnUpdateAlarmVolume(val volume: Float) : SetAlarmAction

    data object OnSaveAlarm : SetAlarmAction
    data object OnBackClicked : SetAlarmAction
    data object OnUpdateRingtone : SetAlarmAction
    data object OnShowUpdateTitleDialog : SetAlarmAction

}