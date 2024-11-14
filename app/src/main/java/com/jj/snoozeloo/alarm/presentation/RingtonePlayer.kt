package com.jj.snoozeloo.alarm.presentation

import android.net.Uri

interface RingtonePlayer {

    fun playRingtone(uri: Uri)
    fun stopRingtone()

}