package com.jj.snoozeloo.alarm.presentation.ringtoneSetting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jj.snoozeloo.alarm.AlarmRingtone
import com.jj.snoozeloo.alarm.domain.LocalAlarmDatasource
import com.jj.snoozeloo.alarm.presentation.SnoozeLooAppRingtoneManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class RingtoneSettingViewModel(
    private val ringtoneManager: SnoozeLooAppRingtoneManager,
    private val alarmRepository: LocalAlarmDatasource
) : ViewModel() {

    private var _uiState = MutableStateFlow(RingtoneSettingState())
    val uiState = _uiState.asStateFlow()


    fun getAlarm(idAlarm: Int?) {

        if(idAlarm!=null){
        viewModelScope.launch {

                val alarm = alarmRepository.getAlarmById(idAlarm)
                if (alarm != null) {
                    _uiState.update {
                        it.copy(
                            alarm = alarm,
                            alarmId = idAlarm
                        )
                    }

                }
            }
        }

        getRingtones()
    }

    fun onAction(action: RingtoneSettingAction) {
        when (action) {
            is RingtoneSettingAction.OnSelectRingtone -> {
                selectRingtone(action.ringtone)
            }

            else -> Unit
        }
    }

    private fun getRingtones() {
        val ringtones = ringtoneManager.getRingtones().map {
            it.copy(
                isSelectedRingtone = it.name == uiState.value.alarm.alarmTone
            )
        }

        _uiState.update {
            it.copy(
                ringtones = ringtones
            )
        }

    }

    private fun selectRingtone(ringtone: AlarmRingtone) {

        ringtoneManager.playRingtone(ringtone.uri)

        _uiState.update {
            it.copy(
                selectedRingtone = ringtone,
                ringtones = it.ringtones.map {
                    it.copy(
                        isSelectedRingtone = it.name == ringtone.name
                    )
                }
            )
        }

//        if (uiState.value.alarmId != null) {
//            val alarm = uiState.value.alarm.copy(
//                alarmTone = ringtone.name
//            )
//
//            viewModelScope.launch {
//                alarmRepository.upsertAlarm(alarm)
//            }
//
//        }

    }

    override fun onCleared() {
        super.onCleared()
        ringtoneManager.stopRingtone()
    }
}
