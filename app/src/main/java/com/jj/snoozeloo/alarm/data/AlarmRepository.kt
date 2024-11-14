package com.jj.snoozeloo.alarm.data

import com.jj.snoozeloo.alarm.data.mappers.toAlarm
import com.jj.snoozeloo.alarm.data.mappers.toAlarmEntity
import com.jj.snoozeloo.alarm.domain.Alarm
import com.jj.snoozeloo.alarm.domain.LocalAlarmDatasource
import com.jj.snoozeloo.core.database.dao.AlarmDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AlarmRepository(
    private val alarmDao: AlarmDao
) : LocalAlarmDatasource {
    override suspend fun upsertAlarm(alarm: Alarm) {
        alarmDao.insertAlarm(alarm.toAlarmEntity())
    }

    override suspend fun deleteAlarm(id: Int) {
        alarmDao.deleteAlarm(id)
    }

    override suspend fun getAlarmById(id: Int): Alarm? {
        return alarmDao.getAlarmById(id)?.toAlarm()
    }

    override fun getAlarms(): Flow<List<Alarm>> {

        return alarmDao.getAlarms().map { alarmEntity ->
            alarmEntity.map { it.toAlarm() }
        }
    }

    override suspend fun updateAlarm(alarm: Alarm) {

    }
}