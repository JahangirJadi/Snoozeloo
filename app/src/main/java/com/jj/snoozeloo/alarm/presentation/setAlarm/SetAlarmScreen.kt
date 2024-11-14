package com.jj.snoozeloo.alarm.presentation.setAlarm

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.jj.snoozeloo.R
import com.jj.snoozeloo.alarm.domain.DaysOfWeek
import com.jj.snoozeloo.alarm.domain.getCurrentSelectedDaysSet
import com.jj.snoozeloo.alarm.presentation.setAlarm.components.AlarmTimePicker
import com.jj.snoozeloo.alarm.presentation.setAlarm.components.ItemAlarmRingtone
import com.jj.snoozeloo.alarm.presentation.setAlarm.components.ItemAlarmVolumeController
import com.jj.snoozeloo.alarm.presentation.setAlarm.components.ItemRepeatAlarm
import com.jj.snoozeloo.alarm.presentation.setAlarm.components.ItemToggleVibration
import com.jj.snoozeloo.core.presentation.designsystem.components.AppTopActionBar
import com.jj.snoozeloo.core.presentation.designsystem.SnoozelooTheme
import com.jj.snoozeloo.core.presentation.designsystem.components.AppBackground
import com.jj.snoozeloo.core.presentation.designsystem.components.AppCard
import com.jj.snoozeloo.core.presentation.designsystem.components.AppText14
import com.jj.snoozeloo.core.presentation.designsystem.components.AppText16
import org.koin.androidx.compose.koinViewModel
import timber.log.Timber

@Composable
fun SetAlarmScreenRoot(
    modifier: Modifier = Modifier,
    idAlarm: Int? = null,
    mViewModel: SetAlarmViewModel,
    onBackPressed: () -> Unit,
    onSetRingtone: (Int?) -> Unit,
) {


    LaunchedEffect(idAlarm,) {
        mViewModel.getAlarmById(idAlarm)

    }

    val state = mViewModel.uiState.collectAsStateWithLifecycle()

    SetAlarmScreen(
        modifier = modifier,
        state = state.value,
        action = { action ->
            when (action) {
                SetAlarmAction.OnBackClicked -> onBackPressed()
                is SetAlarmAction.OnUpdateRingtone -> onSetRingtone(idAlarm)
                else -> {
                    mViewModel.onAction(action)
                }
            }
        }
    )
}


@Composable
fun SetAlarmScreen(
    modifier: Modifier = Modifier,
    action: (SetAlarmAction) -> Unit,
    state: SetAlarmUIState,
) {

    Scaffold(
        topBar = {
            AppTopActionBar(
                modifier = Modifier
                    .systemBarsPadding()
                    .padding(16.dp),
                onSaveClicked = {
                    action(SetAlarmAction.OnSaveAlarm)
                },
                onBackClicked = {
                    action(SetAlarmAction.OnBackClicked)
                },
                canSave = true,
                canGoBack = false,
                onDismissClicked = {}
            )


        }) { padding ->

        AppBackground() {
            Box(
                modifier = modifier
                    .padding(padding)
                    .fillMaxSize()

            ) {


                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {

                    AlarmTimePicker(
                        modifier = Modifier
                            .background(color = MaterialTheme.colorScheme.surface),
                        action = action,
                        currentHour = state.alarm.hour ?: 0,
                        currentMinutes = state.alarm.minute ?: 0

                    )

                    ItemAlarmTitle(title = state.alarm?.title ?: "", onClick = {
                        action(SetAlarmAction.OnShowUpdateTitleDialog)
                    })

                    ItemRepeatAlarm(
                        currentDays = state.alarm?.days.getCurrentSelectedDaysSet(),
                        onSelectedDays = { updatedDays ->

                            action(SetAlarmAction.OnUpdateSelectedDays(updatedDays))

                        }
                    )

                    ItemAlarmRingtone(currentRingtone = state.alarm.alarmTone?:"",
                        onClick = {
                            action(SetAlarmAction.OnUpdateRingtone)
                        })

                    ItemAlarmVolumeController(currentVolume = state.alarm?.alarmVolume?.toFloat()
                        ?: 0f,
                        onVolumeChange = {
                            action(SetAlarmAction.OnUpdateAlarmVolume(it))
                        })

                    ItemToggleVibration(currentState = state.alarm?.isOnVibrate ?: false,
                        onToggle = {
                            action(SetAlarmAction.OnToggleVibration(it))

                        })

                }


            }
        }

    }
}


@Composable
private fun ItemAlarmTitle(
    onClick: () -> Unit,
    title: String
) {
    AppCard(
        modifier = Modifier.clickable {
            onClick()
        }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            AppText16(
                text = stringResource(R.string.alarm_name),
                fontWeight = FontWeight.W600
            )

            AppText14(
                text = title,
                fontWeight = FontWeight.W500,
                color = MaterialTheme.colorScheme.secondary
            )


        }
    }
}


@PreviewLightDark
@Composable
private fun SetAlarmScreenPreview() {
    SnoozelooTheme {
        SetAlarmScreen(
            action = {},
            state = SetAlarmUIState(),

            )
    }
}