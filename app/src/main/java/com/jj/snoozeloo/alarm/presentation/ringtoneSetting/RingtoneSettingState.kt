package com.jj.snoozeloo.alarm.presentation.ringtoneSetting

import com.jj.snoozeloo.alarm.AlarmRingtone
import com.jj.snoozeloo.alarm.domain.Alarm

data class RingtoneSettingState(
    val ringtones: List<AlarmRingtone> = emptyList(),
    val alarmId: Int? = null,
    val alarm: Alarm = Alarm(),
    val selectedRingtone: AlarmRingtone? = null,
    val isSelectingRingtone: Boolean = false
)
