package com.jj.snoozeloo.alarm.presentation.alarmList.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jj.snoozeloo.R
import com.jj.snoozeloo.alarm.domain.Alarm
import com.jj.snoozeloo.alarm.domain.DaysOfWeek
import com.jj.snoozeloo.alarm.domain.Meridian
import com.jj.snoozeloo.alarm.domain.getCurrentSelectedDaysSet
import com.jj.snoozeloo.core.presentation.designsystem.SnoozelooTheme
import com.jj.snoozeloo.core.presentation.designsystem.components.AppCard
import com.jj.snoozeloo.core.presentation.designsystem.components.AppText14
import com.jj.snoozeloo.core.presentation.designsystem.components.AppText20

@Composable
fun ItemAlarm(
    modifier: Modifier = Modifier,
    alarm: Alarm,
    onClick: () -> Unit
) {

    AppCard(modifier = modifier
        .clickable {
            onClick()
        }
        .fillMaxWidth()) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                AppText20(text = alarm.title)
                Switch(
                    checked = alarm.isActive, onCheckedChange = {

                    },
                    colors = SwitchDefaults.colors(
                        checkedTrackColor = MaterialTheme.colorScheme.primary,
                        uncheckedThumbColor = MaterialTheme.colorScheme.secondary
                    )
                )

            }

            Text(buildAnnotatedString {

                withStyle(
                    SpanStyle(
                        color = MaterialTheme.colorScheme.onSurface,
                        fontSize = 42.sp,
                        fontWeight = FontWeight.Medium
                    )
                ) {
                    append(alarm.time)
                }

                withStyle(
                    SpanStyle(
                        color = MaterialTheme.colorScheme.onSurface,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.W500
                    )
                ) {
                    append(" ${alarm.meridian.name}")
                }

            })

            AppText14(
                text = "Alarm in 30min",
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )

            DaysChipsGroup(
                selectedDays = alarm.days.getCurrentSelectedDaysSet(),
                onSelectDays = {},
                isEnabled = false
            )

            AppText14(
                text = "Go to bed at 02:00AM to get 8h of sleep",
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )


        }
    }

}

@PreviewLightDark
@Composable
private fun ItemAlarmPreview() {
    SnoozelooTheme {
        ItemAlarm(
            alarm = previewAlarm,
            onClick = {}
        )
    }
}

internal val previewAlarm = Alarm(
    id = 1,
    title = "Alarm 1",
    time = "12:00",
    isActive = true,
    alarmTone = "Default",
    alarmVolume = 50,
    hour = 12,
    minute = 0,
    meridian = Meridian.AM,
    days = DaysOfWeek(
        mon = true,
        tue = true,
        wed = true,
        thu = true,
        fri = true,
        sat = true,
        sun = true

    ),
    isOnVibrate = false

)