package com.jj.snoozeloo.alarm.presentation.alarmList.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.jj.snoozeloo.alarm.domain.Alarm
import com.jj.snoozeloo.core.presentation.designsystem.SnoozelooTheme


@Composable
fun AlarmList(list: List<Alarm>, onClick: (Int) -> Unit) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(list, key = { it.id?:0 }) {
            ItemAlarm(alarm = it, onClick = {
                onClick(it.id?:0)
            })
        }
    }
}

@PreviewLightDark
@Preview(showBackground = true)
@Composable
private fun AlarmListPreview() {
    SnoozelooTheme {
        AlarmList(list =
        (1..10).map {
            previewAlarm.copy(id = it, title = "Alarm ${it}")
        }, onClick = {})
    }
}