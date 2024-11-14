package com.jj.snoozeloo.core.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class AlarmEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val hour: Int,
    val minute: Int,
    val title: String,
    val time: String,
    val isActive: Boolean,
    val isOnVibrate: Boolean,
    val alarmTone: String,
    val alarmVolume: Int,
    val mon: Boolean = false,
    val tue: Boolean = false,
    val wed: Boolean = false,
    val thu: Boolean = false,
    val fri: Boolean = false,
    val sat: Boolean = false,
    val sun: Boolean = false,
)
