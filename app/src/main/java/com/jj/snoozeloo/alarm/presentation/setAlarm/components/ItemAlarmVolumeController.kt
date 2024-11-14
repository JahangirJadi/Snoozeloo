package com.jj.snoozeloo.alarm.presentation.setAlarm.components

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
fun ItemAlarmVolumeController(
    modifier: Modifier = Modifier,
    currentVolume: Float,
    onVolumeChange: (Float) -> Unit
) {

    val sliderPosition by remember(currentVolume) {
        mutableFloatStateOf(currentVolume)
    }


    AppCard {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            AppText16(
                text = stringResource(R.string.alarm_volume),
                fontWeight = FontWeight.W600
            )

            Slider(value = sliderPosition,
                valueRange = 0f .. 100f,
                onValueChange = {
                    onVolumeChange(it)
                })

        }
    }

}

@Preview
@Composable
private fun ItemAlarmVolumeControllerPreview() {
    SnoozelooTheme {
        ItemAlarmVolumeController(currentVolume = 0.3f,
            onVolumeChange = {})
    }
}