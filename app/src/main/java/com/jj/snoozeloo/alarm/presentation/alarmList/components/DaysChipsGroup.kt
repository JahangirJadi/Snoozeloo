package com.jj.snoozeloo.alarm.presentation.alarmList.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.jj.snoozeloo.core.presentation.designsystem.SnoozelooTheme
import com.jj.snoozeloo.core.presentation.designsystem.components.AppText12



@OptIn(ExperimentalLayoutApi::class)
@Composable
fun DaysChipsGroup(
    modifier: Modifier = Modifier,
    selectedDays: Set<String>,
    isEnabled:Boolean = true,
    onSelectDays: (Set<String>) -> Unit
) {
    val days = listOf("Mo", "Tu", "We", "Th", "Fr", "Sa", "Su")

    FlowRow(
        modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {

        days.forEach { day ->

            DayChip(
                value = day, onClick = {

                    val updatedDays = if (selectedDays.contains(day)) {
                        selectedDays - day
                    } else {
                        selectedDays + day
                    }

                    onSelectDays(updatedDays)

                },
                isSelected = selectedDays.contains(day),
                isEnabled = isEnabled

            )

        }
    }
}

@Composable
private fun DayChip(
    modifier: Modifier = Modifier,
    value: String,
    isSelected: Boolean,
    isEnabled: Boolean = true,
    onClick: () -> Unit
) {

    Box(
        modifier = modifier
            .width(38.dp)
            .height(26.dp)

            .clip(shape = RoundedCornerShape(38.dp))
            .background(
                color = if (isSelected) MaterialTheme.colorScheme.primary
                else MaterialTheme.colorScheme.secondaryContainer,
                shape = RoundedCornerShape(38.dp)
            )
            .clickable(
                onClick = onClick,
                enabled = isEnabled
            )
            ,
        contentAlignment = Alignment.Center
    ) {
        AppText12(
            text = value,
            color = if (isSelected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSecondaryContainer
        )
    }
//
//
//
//    FilterChip(
//        modifier = Modifier.height(26.dp),
//        shape = RoundedCornerShape(38.dp),
//        onClick = onClick,
//        border = null,
//        colors = FilterChipDefaults.filterChipColors(
//            containerColor = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondaryContainer,
//            selectedContainerColor = MaterialTheme.colorScheme.primary,
//        ),
//        label = {
//            AppText12(
//                text = value,
//                color = if (isSelected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSecondaryContainer
//            )
//
//        },
//        selected = isSelected
//    )
}


@PreviewLightDark
@Composable
private fun DaysChipsPreview() {
    SnoozelooTheme {
        DaysChipsGroup(selectedDays = setOf("Mon", "Wed"),
            onSelectDays = {})
    }
}