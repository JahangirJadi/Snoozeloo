package com.jj.snoozeloo.alarm.presentation.setAlarm

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jj.snoozeloo.alarm.domain.Alarm
import com.jj.snoozeloo.alarm.domain.DaysOfWeek
import com.jj.snoozeloo.alarm.domain.LocalAlarmDatasource
import com.jj.snoozeloo.alarm.domain.Meridian
import com.jj.snoozeloo.alarm.domain.getDaysOfWeek
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

class SetAlarmViewModel(
    private val alarmRepository: LocalAlarmDatasource,

) : ViewModel() {

    private val TAG = "SetAlarmViewModel"

    private var _uiState = MutableStateFlow(SetAlarmUIState())
    val uiState = _uiState.asStateFlow()

    fun onAction(action: SetAlarmAction) {
        when (action) {

            is SetAlarmAction.OnUpdateHour ->{
                _uiState.update {
                    it.copy(
                        alarm = it.alarm.copy(
                            hour = action.hour
                        )

                    )
                }
            }

            is SetAlarmAction.OnUpdateMinute ->{
                _uiState.update {
                    it.copy(
                        alarm = it.alarm.copy(
                            minute = action.minute
                        )

                    )
                }
            }

            SetAlarmAction.OnSaveAlarm -> {
                saveAlarm()
            }

            is SetAlarmAction.OnUpdateSelectedDays -> {
                _uiState.update {
                    it.copy(
                        alarm = it.alarm.copy(
                            days = action.updatedDays.getDaysOfWeek()
                        )
                    )
                }
            }

            is SetAlarmAction.OnSelectRingtone -> {

            }

            is SetAlarmAction.OnSetVolume -> {

                _uiState.update {
                    it.copy(
                        alarm = it.alarm.copy(
                            alarmVolume = action.volume
                        )
                    )
                }

            }

            SetAlarmAction.OnShowUpdateTitleDialog -> {

            }
            is SetAlarmAction.OnToggleVibration -> {
                _uiState.update {
                    it.copy(
                        alarm = it.alarm.copy(
                            isOnVibrate = action.shouldVibrate
                        )
                    )
                }
            }
            is SetAlarmAction.OnUpdateAlarmVolume -> {


                _uiState.update {
                    it.copy(
                        alarm = it.alarm.copy(
                            alarmVolume = action.volume.roundToInt()
                        ).also {
                            Log.d("TAG", "OnUpdateAlarmVolume: ${it?.alarmVolume}")

                        }
                    )
                }
            }
            SetAlarmAction.OnUpdateRingtone -> {

            }

            else -> Unit
        }

    }


    private fun saveAlarm() {

        val alarmModel = uiState.value.alarm

        val alarm = Alarm(
            id = uiState.value.idAlarm,
            title = alarmModel.title,
            time = "${alarmModel.hour}:${alarmModel.minute}",
            hour = alarmModel.hour,
            minute = alarmModel.minute,
            isActive = true,
            alarmTone = alarmModel.alarmTone,
            alarmVolume = alarmModel.alarmVolume,
            days = alarmModel.days,
            meridian = if(alarmModel.hour>12) Meridian.PM else Meridian.AM,
        )

        viewModelScope.launch {
            alarmRepository.upsertAlarm(alarm)
        }

    }

    fun getAlarmById(idAlarm: Int?) {
        if (idAlarm == null) return
        viewModelScope.launch {
            val alarm = alarmRepository.getAlarmById(idAlarm)

            Log.d(TAG, "getAlarmById: $alarm")

            if(alarm!=null){

                _uiState.update {
                    it.copy(
                        alarm = alarm,
                        idAlarm = idAlarm
                    )
                }

            }else{
                Log.d(TAG, "getAlarmById: Alarm not found")
            }

        }
    }

    fun updateRingtone(resultedRingtone: String) {
        _uiState.update {
            it.copy(
                alarm = it.alarm.copy(
                    alarmTone = resultedRingtone
                )
            )
        }
    }


}