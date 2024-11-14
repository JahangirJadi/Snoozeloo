package com.jj.snoozeloo.alarm.presentation.alarmList

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.jj.snoozeloo.R
import com.jj.snoozeloo.alarm.domain.Alarm
import com.jj.snoozeloo.alarm.presentation.alarmList.components.AlarmList
import com.jj.snoozeloo.alarm.presentation.alarmList.components.NoAlarmsFound
import com.jj.snoozeloo.core.presentation.designsystem.AppIcons
import com.jj.snoozeloo.core.presentation.designsystem.SnoozelooTheme
import com.jj.snoozeloo.core.presentation.designsystem.components.AppBackground
import com.jj.snoozeloo.core.presentation.designsystem.components.AppText16
import com.jj.snoozeloo.core.presentation.designsystem.components.AppText24
import org.koin.androidx.compose.koinViewModel

@Composable
fun MyAlarmListScreenRoot(
    modifier: Modifier = Modifier,
    viewModel: MyAlarmListViewModel = koinViewModel(),
    onCreateAlarm:()->Unit,
    onEditAlarm:(Int)->Unit,
) {

    val state = viewModel.alarmListState.collectAsStateWithLifecycle()

    MyAlarmListScreen(
        state = state.value,
        modifier = modifier,
        action = {action ->

            when(action){
                is AlarmListAction.OnCreateAlarm -> onCreateAlarm()
                is AlarmListAction.OnEditAlarm -> onEditAlarm(action.idAlarm)
                else -> Unit
            }

        }
    )

}


@Composable
fun MyAlarmListScreen(
    modifier: Modifier = Modifier,
    state: AlarmListState,
    action: (AlarmListAction) -> Unit
) {

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    action(AlarmListAction.OnCreateAlarm)
                },
                shape = CircleShape, containerColor = MaterialTheme.colorScheme.primary,

                ) {
                Icon(
                    imageVector = AppIcons.add,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimary,
                )
            }
        },
        floatingActionButtonPosition = FabPosition.Center
    ) { padding ->

        AppBackground {
            Box(
                modifier = modifier
                    .padding(padding)
                    .fillMaxSize()
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {

                    AppText24(text = stringResource(R.string.my_alarms))

                    Spacer(Modifier.height(16.dp))

                    AlarmList(list = state.alarmList,
                        onClick = {
                            action(AlarmListAction.OnEditAlarm(it))
                        })

                }

                if (state.alarmList.isEmpty()) {

                    NoAlarmsFound(modifier = Modifier.align(Alignment.Center))


                }


            }

        }
    }


}


@Preview
@Composable
private fun MyAlarmListScreenPreview() {
    SnoozelooTheme {
        MyAlarmListScreen(state = AlarmListState(),
            action = {})
    }
}