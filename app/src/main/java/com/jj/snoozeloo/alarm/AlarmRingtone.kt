package com.jj.snoozeloo.alarm

import android.net.Uri

data class AlarmRingtone(
    val name: String,
    val uri: Uri,
    val isSelectedRingtone:Boolean = false
)
