package com.jj.snoozeloo.alarm.presentation.ringtoneSetting

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.jj.snoozeloo.alarm.AlarmRingtone
import com.jj.snoozeloo.alarm.presentation.ringtoneSetting.components.RingtoneList
import com.jj.snoozeloo.core.presentation.designsystem.SnoozelooTheme
import com.jj.snoozeloo.core.presentation.designsystem.components.AppBackButton
import org.koin.androidx.compose.koinViewModel

@Composable
fun RingtoneSettingScreenRoot(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    onRingtoneSelected: (AlarmRingtone) -> Unit,
    mViewModel: RingtoneSettingViewModel = koinViewModel(),
    idAlarm: Int?
) {

    LaunchedEffect(idAlarm) {
        mViewModel.getAlarm(idAlarm)
    }
//
    val state = mViewModel.uiState.collectAsStateWithLifecycle()

    RingtoneSettingScreen(
        modifier = modifier,
        state = state.value,
        action = { action ->
            when (action) {
                RingtoneSettingAction.OnBackClick -> {
                    if (state.value.selectedRingtone != null) {
                        onRingtoneSelected(state.value.selectedRingtone!!)
                    } else {
                        onBackClick()
                    }
                }

                else -> {
                    mViewModel.onAction(action)
                }

            }
        }
    )

}

@Composable
fun RingtoneSettingScreen(
    modifier: Modifier = Modifier,
    state: RingtoneSettingState,
    action: (RingtoneSettingAction) -> Unit
) {

    Column(
        modifier = modifier
            .systemBarsPadding()
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        AppBackButton(onClick = {
            action(RingtoneSettingAction.OnBackClick)
        })

        RingtoneList(list = state.ringtones,
            onClick = { ringtone ->
                action(RingtoneSettingAction.OnSelectRingtone(ringtone))
            })

    }

}

@Preview
@Composable
private fun RingtoneSettingScreenPreview() {
    SnoozelooTheme {
        RingtoneSettingScreen(
            state = RingtoneSettingState(),
            action = {}
        )
    }
}