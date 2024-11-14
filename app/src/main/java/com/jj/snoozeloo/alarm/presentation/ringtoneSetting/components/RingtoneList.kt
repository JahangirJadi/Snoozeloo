package com.jj.snoozeloo.alarm.presentation.ringtoneSetting.components

import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jj.snoozeloo.alarm.AlarmRingtone
import com.jj.snoozeloo.alarm.presentation.ringtoneSetting.RingtoneSettingAction
import com.jj.snoozeloo.core.presentation.designsystem.SnoozelooTheme

@Composable
fun RingtoneList(
    modifier: Modifier = Modifier, list: List<AlarmRingtone>,
    onClick: (AlarmRingtone) -> Unit
) {

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(list) { ringtone ->

            ItemRingtone(ringtone = ringtone, onClick = {
                onClick(ringtone)
            })

        }
    }


}


@Preview
@Composable
private fun RingtoneListPreview() {
    SnoozelooTheme {
        RingtoneList(
            list = (1..10).map {
                AlarmRingtone(name = "Ringtone ${it + 1}", uri = Uri.EMPTY)
            },
            onClick = {}
        )
    }
}