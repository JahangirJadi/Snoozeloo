package com.jj.snoozeloo.alarm.presentation.ringtoneSetting.components

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.jj.snoozeloo.alarm.AlarmRingtone
import com.jj.snoozeloo.core.presentation.designsystem.AppIcons
import com.jj.snoozeloo.core.presentation.designsystem.SnoozelooTheme
import com.jj.snoozeloo.core.presentation.designsystem.components.AppCard
import com.jj.snoozeloo.core.presentation.designsystem.components.AppText14

@Composable
fun ItemRingtone(
    modifier: Modifier = Modifier,
    ringtone: AlarmRingtone,
    onClick: () -> Unit
) {

    AppCard(modifier = modifier.clickable {
        onClick()
    }) {
        ListItem(
            headlineContent = {
                AppText14(
                    text = ringtone.name,
                    fontWeight = FontWeight.W600
                )
            },
            leadingContent = {
                if (ringtone.name == "Silent") {
                    Box(
                        modifier = Modifier
                            .size(30.dp)
                            .background(
                                color = MaterialTheme.colorScheme.secondary,
                                shape = CircleShape
                            ),
                        contentAlignment = Alignment.Center
                    ) {

                        Icon(
                            imageVector = AppIcons.silent,
                            contentDescription = "",
                            modifier = Modifier.size(18.dp),
                            tint = MaterialTheme.colorScheme.onSecondary

                        )
                    }
                } else {
                    Box(
                        modifier = Modifier
                            .size(30.dp)
                            .background(
                                color = MaterialTheme.colorScheme.secondary,
                                shape = CircleShape
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = AppIcons.notification,
                            contentDescription = "",
                            modifier = Modifier.size(18.dp),
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    }

                }
            },
            trailingContent = {
                if (ringtone.isSelectedRingtone) {
                    Icon(
                        imageVector = AppIcons.roundCheck,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
        )
    }

}


@PreviewLightDark
@Composable
private fun RingtoneItemPreview() {
    SnoozelooTheme {
        ItemRingtone(
            onClick = {},
            ringtone = AlarmRingtone(
                name = "Default",
                isSelectedRingtone = true,
                uri = Uri.EMPTY
            )
        )
    }
}

