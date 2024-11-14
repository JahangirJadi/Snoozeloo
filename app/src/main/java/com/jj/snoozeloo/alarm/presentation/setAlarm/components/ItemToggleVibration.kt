package com.jj.snoozeloo.alarm.presentation.setAlarm.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jj.snoozeloo.R
import com.jj.snoozeloo.core.presentation.designsystem.SnoozelooTheme
import com.jj.snoozeloo.core.presentation.designsystem.components.AppCard
import com.jj.snoozeloo.core.presentation.designsystem.components.AppText14
import com.jj.snoozeloo.core.presentation.designsystem.components.AppText16

@Composable
fun ItemToggleVibration(
    modifier: Modifier = Modifier,
    currentState: Boolean,
    onToggle: (Boolean) -> Unit
) {

    AppCard {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            AppText16(
                text = stringResource(R.string.vibrate),
                fontWeight = FontWeight.W600,
            )

            Switch(checked = currentState,
                onCheckedChange = {
                    onToggle(it)
                })

        }
    }

}

@Preview
@Composable
private fun ItemToggleVibrationPreview() {
    SnoozelooTheme {
        ItemToggleVibration(currentState = true, onToggle = {})
    }
}