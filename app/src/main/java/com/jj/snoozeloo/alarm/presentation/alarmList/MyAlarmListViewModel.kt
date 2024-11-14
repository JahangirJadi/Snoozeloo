package com.jj.snoozeloo.alarm.presentation.alarmList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jj.snoozeloo.alarm.domain.LocalAlarmDatasource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn

class MyAlarmListViewModel
    (
    alarmRepository: LocalAlarmDatasource
) : ViewModel() {

    private var _alarmListState = MutableStateFlow(AlarmListState())
    val alarmListState = _alarmListState.asStateFlow()


    init {

        alarmRepository.getAlarms().onEach {
            println("ALARM LIST:::${it.joinToString()}")
            _alarmListState.value = _alarmListState.value.copy(
                alarmList = it
            )

        }.launchIn(viewModelScope)

        alarmRepository.getAlarms()

            .onEach {

                println("ALARM LIST:::${it.joinToString()}")

                _alarmListState.value = _alarmListState.value.copy(
                    alarmList = it
                )
            }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), AlarmListState())


    }


}