package com.jj.snoozeloo.alarm.presentation

import android.content.Context
import android.media.RingtoneManager
import android.net.Uri
import com.jj.snoozeloo.alarm.AlarmRingtone

class SnoozeLooAppRingtoneManager(
    private val context: Context,
    private val ringtonePlayer: AppPlayer
) : AppRingtoneManager {



    override fun changeRingtone(alarmRingtone: AlarmRingtone) {

    }

    override fun playRingtone(uri: Uri) {
        ringtonePlayer.playRingtone(uri)
    }

    override fun stopRingtone() {
        ringtonePlayer.stopRingtone()
    }

    override fun getRingtones(): List<AlarmRingtone> {

         val ringtoneManager =
            RingtoneManager(context).apply {
                setType(RingtoneManager.TYPE_RINGTONE)
            }

        val cursor = ringtoneManager.cursor ?: return emptyList()
        val ringtones = mutableListOf<AlarmRingtone>()
        while (cursor.moveToNext()) {
            val title = cursor.getString(RingtoneManager.TITLE_COLUMN_INDEX)
            val uri = cursor.getString(RingtoneManager.URI_COLUMN_INDEX) + "/" + cursor.getString(
                RingtoneManager.ID_COLUMN_INDEX
            )

            val alarmRingtone = AlarmRingtone(title, Uri.parse(uri))
            ringtones.add(alarmRingtone)
        }
        cursor.close()
        return ringtones

    }


}