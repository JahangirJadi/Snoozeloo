package com.jj.snoozeloo.core.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.jj.snoozeloo.core.database.AlarmEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AlarmDao {

    @Upsert
    suspend fun insertAlarm(alarmEntity: AlarmEntity)

    @Query("Select * from AlarmEntity")
    fun getAlarms(): Flow<List<AlarmEntity>>

    @Query("Select * from AlarmEntity where id = :id")
    suspend fun getAlarmById(id: Int): AlarmEntity?

    @Query("Delete from AlarmEntity where id = :id")
    suspend fun deleteAlarm(id: Int)



}