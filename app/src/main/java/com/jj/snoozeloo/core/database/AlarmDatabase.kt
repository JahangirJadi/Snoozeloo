package com.jj.snoozeloo.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jj.snoozeloo.core.database.dao.AlarmDao

@Database(
    entities = [AlarmEntity::class],
    version = 3
)
abstract class AlarmDatabase: RoomDatabase() {

    abstract val alarmDao: AlarmDao

}