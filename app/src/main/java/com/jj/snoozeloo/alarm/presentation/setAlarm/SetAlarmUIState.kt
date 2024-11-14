package com.jj.snoozeloo.alarm.presentation.setAlarm

import androidx.compose.foundation.text.input.TextFieldState
import com.jj.snoozeloo.alarm.domain.Alarm

data class SetAlarmUIState(
    val idAlarm:Int?=null,
    val alarm: Alarm = Alarm(),
    val isLoading:Boolean = false,
    val error:String? = null
){
    companion object
    {
        fun defaultDays(): List<HashMap<String, Boolean>> {
            return listOf(
                hashMapOf("Monday" to false),
                hashMapOf("Tuesday" to false),
                hashMapOf("Wednesday" to false),
                hashMapOf("Thursday" to false),
                hashMapOf("Friday" to false),
                hashMapOf("Saturday" to false),
                hashMapOf("Sunday" to false),
            )
        }
    }
}

