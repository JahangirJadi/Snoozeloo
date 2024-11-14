package com.jj.snoozeloo.alarm.domain

import androidx.compose.runtime.Stable

enum class Meridian {
    AM,
    PM
}

@Stable
data class Alarm(
    val id: Int? = 0,
    val title: String = "",
    val meridian: Meridian = Meridian.AM,
    val hour: Int = 0,
    val minute: Int = 0,
    val time: String = "00:00",
    val days: DaysOfWeek = DaysOfWeek(),
    val isActive: Boolean = true,
    val alarmTone: String = "Default",
    val alarmVolume: Int = 0,
    val isOnVibrate: Boolean = false
)

fun Set<String>.getDaysOfWeek(): DaysOfWeek {
    return DaysOfWeek(
        mon = "Mo" in this,
        tue = "Tu" in this,
        wed = "We" in this,
        thu = "Th" in this,
        fri = "Fr" in this,
        sat = "Sa" in this,
        sun = "Su" in this
    )
}

fun DaysOfWeek?.getCurrentSelectedDaysSet(): Set<String> {

    if (this == null) return emptySet()

    val dayMap = mapOf(
        "Mo" to mon,
        "Tu" to tue,
        "We" to wed,
        "Th" to thu,
        "Fr" to fri,
        "Sa" to sat,
        "Su" to sun
    )
    return dayMap.filter { it.value }.keys
}


data class DaysOfWeek(
    val mon: Boolean = false,
    val tue: Boolean = false,
    val wed: Boolean = false,
    val thu: Boolean = false,
    val fri: Boolean = false,
    val sat: Boolean = false,
    val sun: Boolean = false,
)