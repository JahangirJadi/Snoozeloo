package com.jj.snoozeloo.alarm.presentation.alarmList.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.jj.snoozeloo.R
import com.jj.snoozeloo.core.presentation.designsystem.AppIcons
import com.jj.snoozeloo.core.presentation.designsystem.components.AppText16

@Composable
fun NoAlarmsFound(modifier: Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Icon(
            imageVector = AppIcons.alarm, contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(62.dp)
        )

        Spacer(Modifier.height(32.dp))

        AppText16(
            text = stringResource(R.string.no_alarms),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.W500
        )
    }
}
