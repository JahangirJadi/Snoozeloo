package com.jj.snoozeloo.core.presentation.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jj.snoozeloo.core.presentation.designsystem.AppIcons
import com.jj.snoozeloo.core.presentation.designsystem.SnoozelooTheme

@Composable
fun AppBackButton(modifier: Modifier = Modifier,onClick:()->Unit) {
    Icon(
        imageVector = AppIcons.arrowBack ,
        contentDescription = null,
        modifier = modifier
            .size(32.dp)
            .clip(shape = RoundedCornerShape(4.dp))
            .background(
                color = MaterialTheme.colorScheme.primary
            )
            .clickable(enabled = true, onClick = onClick),
        tint = MaterialTheme.colorScheme.onPrimary
    )
}


@Preview
@Composable
private fun AppBackButtonPreview() {
    SnoozelooTheme {
        AppBackButton(
            onClick = {}
        )
    }
}