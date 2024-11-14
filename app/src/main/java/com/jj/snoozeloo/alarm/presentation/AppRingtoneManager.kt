package com.jj.snoozeloo.alarm.presentation

import android.media.Ringtone
import android.net.Uri
import com.jj.snoozeloo.alarm.AlarmRingtone


interface AppRingtoneManager {
    fun getRingtones(): List<AlarmRingtone>
    fun playRingtone(uri: Uri)
    fun stopRingtone()
    fun changeRingtone(alarmRingtone: AlarmRingtone)

}

