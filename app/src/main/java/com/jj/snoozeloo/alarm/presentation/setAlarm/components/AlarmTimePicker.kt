package com.jj.snoozeloo.alarm.presentation.setAlarm.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jj.snoozeloo.alarm.presentation.setAlarm.SetAlarmAction
import com.jj.snoozeloo.core.presentation.designsystem.AppIcons
import com.jj.snoozeloo.core.presentation.designsystem.SnoozelooTheme
import com.jj.snoozeloo.core.presentation.designsystem.components.AppCard
import com.jj.snoozeloo.core.presentation.designsystem.components.AppText14
import com.jj.snoozeloo.core.presentation.designsystem.montserrat

enum class TimeCat {
    Hour,
    Minute
}

@Composable
fun AlarmTimePicker(
    modifier: Modifier = Modifier,
    action: (SetAlarmAction) -> Unit,
    currentHour: Int,
    currentMinutes: Int
) {


    AppCard(
        modifier = modifier.fillMaxWidth()
    ) {

        Column(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                TimePickerBlock(Modifier.weight(1f),
                    timeCat = TimeCat.Hour, currentHour, onValueChange = {
                        action(SetAlarmAction.OnUpdateHour(it))
                    })
                Icon(imageVector = AppIcons.colon, contentDescription = null)
                TimePickerBlock(
                    Modifier.weight(1f),
                    timeCat = TimeCat.Minute,
                    currentMinutes,
                    onValueChange = {
                        action(SetAlarmAction.OnUpdateMinute(it))
                    })
            }
            Spacer(Modifier.height(16.dp))
            AppText14(
                text = "Alarm in 7h 15min",
                color = MaterialTheme.colorScheme.onSurface
            )

        }
    }

}

@Composable
fun TimePickerBlock(
    modifier: Modifier,
    timeCat: TimeCat,
    value: Int,
    onValueChange: (Int) -> Unit
) {

    var newValue by rememberSaveable(value) {
        mutableStateOf(value.toString())
    }

    val maxLimit = if (timeCat == TimeCat.Hour) 23 else 59

    Box(
        modifier = modifier.background(
            color = MaterialTheme.colorScheme.secondaryContainer,
            shape = RoundedCornerShape(10.dp)
        ), contentAlignment = Alignment.Center
    ) {


        BasicTextField(
            value = newValue,
            onValueChange = {
                if (it.length > 2) return@BasicTextField
                if(it.isEmpty()) {
                    newValue = ""
                    return@BasicTextField
                }


                    newValue = if (it.toInt() > maxLimit) {
                        maxLimit.toString()
                    } else {
                        it
                    }

                    onValueChange(newValue.toInt())


            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
            textStyle = TextStyle(
                fontSize = 52.sp,
                fontWeight = FontWeight.W500,
                fontFamily = montserrat,
                textAlign = TextAlign.Center, color = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier
                .padding(vertical = 16.dp)
                .fillMaxWidth(),


            )
    }
}


@PreviewLightDark
@Composable
private fun ItemAlarmTimePrev() {
    SnoozelooTheme {
        AlarmTimePicker(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.surface),
            currentHour = 0, currentMinutes = 0,
            action = {}

        )
    }
}