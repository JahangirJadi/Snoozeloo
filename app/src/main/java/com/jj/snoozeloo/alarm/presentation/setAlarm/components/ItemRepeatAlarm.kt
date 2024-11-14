package com.jj.snoozeloo.alarm.presentation.setAlarm.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jj.snoozeloo.R
import com.jj.snoozeloo.alarm.presentation.alarmList.components.DaysChipsGroup
import com.jj.snoozeloo.core.presentation.designsystem.SnoozelooTheme
import com.jj.snoozeloo.core.presentation.designsystem.components.AppCard
import com.jj.snoozeloo.core.presentation.designsystem.components.AppText16

@Composable
fun ItemRepeatAlarm(modifier: Modifier = Modifier,
                    currentDays:Set<String>,
                    onSelectedDays:(Set<String>)->Unit) {

    AppCard {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            AppText16(text = stringResource(R.string.repeat),
                fontWeight = FontWeight.W600)

            DaysChipsGroup(
                selectedDays = currentDays,
                onSelectDays = onSelectedDays
            )

        }
    }

}

@Preview
@Composable
private fun ItemRepeatAlarmPreview() {
   SnoozelooTheme {
       ItemRepeatAlarm(
           onSelectedDays = {},
           currentDays = setOf("Mo","Tue")
       )
   }
}