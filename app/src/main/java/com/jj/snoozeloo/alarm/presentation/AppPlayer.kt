package com.jj.snoozeloo.alarm.presentation

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import android.provider.MediaStore.Audio.Media
import timber.log.Timber

class AppPlayer(private val context: Context) : RingtonePlayer {

    private val TAG = "AppPlayer"

    private var mediaPlayer: MediaPlayer?=null


    override fun playRingtone(uri: Uri) {
        mediaPlayer?.release()
        mediaPlayer = null
        mediaPlayer = MediaPlayer()

        Timber.i("$TAG trying to play ringtone")

        try {
            if (mediaPlayer!!.isPlaying) {
                Timber.i("$TAG Stopping if already playing")
                mediaPlayer!!.stop()
            }

            Timber.i("$TAG trying to set data source::: $uri")

            mediaPlayer!!.apply {
                setDataSource(context, uri)
                prepareAsync()
            }
            mediaPlayer!!.setOnPreparedListener {

                Timber.i("$TAG Prepared")
                it.start()
            }

        } catch (e: IllegalStateException) {
            e.printStackTrace()
        }

    }

    override fun stopRingtone() {
        mediaPlayer?.release()
        mediaPlayer = null
    }

}