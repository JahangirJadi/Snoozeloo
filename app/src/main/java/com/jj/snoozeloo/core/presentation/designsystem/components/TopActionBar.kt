package com.jj.snoozeloo.core.presentation.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jj.snoozeloo.core.presentation.designsystem.AppIcons
import com.jj.snoozeloo.core.presentation.designsystem.SnoozelooTheme

@Composable
fun AppTopActionBar(
    modifier: Modifier = Modifier,
    onSaveClicked: () -> Unit,
    canSave: Boolean = true,
    canGoBack: Boolean = true,
    onBackClicked: () -> Unit,
    onDismissClicked: () -> Unit,
) {

    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {


        Icon(
            imageVector = if (canGoBack) AppIcons.arrowBack else AppIcons.close,
            contentDescription = null,
            modifier = Modifier
                .size(32.dp)
                .clip(shape = RoundedCornerShape(4.dp))
                .background(
                    color = MaterialTheme.colorScheme.primary
                ).clickable(enabled = true, onClick = {
                    if(canGoBack){
                        onBackClicked()
                    }else{
                        onDismissClicked()
                    }
                }),
            tint = MaterialTheme.colorScheme.onPrimary
        )


        Text(
            text = "Save",
            modifier = Modifier
                .clip(shape = RoundedCornerShape(32.dp))
                .background(
                    color = MaterialTheme.colorScheme.primary,
                    shape = RoundedCornerShape(32.dp)
                )
                .clickable(enabled = canSave, onClick = {
                    onSaveClicked()
                })
                .padding(vertical = 8.dp, horizontal = 16.dp),
            color = MaterialTheme.colorScheme.onTertiary
        )


    }

}

@Preview
@Composable
private fun AppTopActionBarPrev() {
    SnoozelooTheme {
        AppTopActionBar(
            onSaveClicked = {},
            onBackClicked = {},
            onDismissClicked = {}

        )
    }
}