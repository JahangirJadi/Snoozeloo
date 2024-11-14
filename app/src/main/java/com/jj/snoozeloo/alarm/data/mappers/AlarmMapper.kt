package com.jj.snoozeloo.alarm.data.mappers

import com.jj.snoozeloo.core.database.AlarmEntity
import com.jj.snoozeloo.alarm.domain.Alarm
import com.jj.snoozeloo.alarm.domain.DaysOfWeek
import com.jj.snoozeloo.alarm.domain.Meridian


fun Alarm.toAlarmEntity(): AlarmEntity {
    return AlarmEntity(
        id = id?:0,
        title = title,
        time = time,
        isActive = isActive,
        alarmTone = alarmTone,
        alarmVolume = alarmVolume,
        hour = hour,
        minute = minute,
        mon = days.mon,
        tue = days.tue,
        wed = days.wed,
        thu = days.thu,
        fri = days.fri,
        sat = days.sat,
        sun = days.sun,
        isOnVibrate = isOnVibrate
    )
}


fun AlarmEntity.toAlarm(): Alarm {
    return Alarm(
        id = id,
        title = title,
        time = time,
        isActive = isActive,
        alarmTone = alarmTone,
        alarmVolume = alarmVolume,
        hour = hour,
        minute = minute,
        days = DaysOfWeek(
            mon = mon,
            tue = tue,
            wed = wed,
            thu = thu,
            fri = fri,
            sat = sat,
            sun = sun
        ),
        meridian = Meridian.AM,
        isOnVibrate = isOnVibrate

    )
}