package com.jj.snoozeloo.alarm.domain

import kotlinx.coroutines.flow.Flow


interface LocalAlarmDatasource {

    suspend fun upsertAlarm(alarm: Alarm)

    suspend fun deleteAlarm(id:Int)

    suspend fun getAlarmById(id: Int): Alarm?

     fun getAlarms(): Flow<List<Alarm>>

    suspend fun updateAlarm(alarm: Alarm)


}