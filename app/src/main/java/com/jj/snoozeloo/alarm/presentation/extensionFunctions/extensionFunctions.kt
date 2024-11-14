package com.jj.snoozeloo.alarm.presentation.extensionFunctions



fun Float.roundToIntegerIn10s(): Int {

    return (this * 100).toInt()

}