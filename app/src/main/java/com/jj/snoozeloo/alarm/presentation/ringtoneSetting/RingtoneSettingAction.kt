package com.jj.snoozeloo.alarm.presentation.ringtoneSetting

import com.jj.snoozeloo.alarm.AlarmRingtone

sealed interface RingtoneSettingAction {

    data object OnBackClick: RingtoneSettingAction
    data class  OnSelectRingtone(val ringtone: AlarmRingtone): RingtoneSettingAction
}