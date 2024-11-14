package com.jj.snoozeloo.core.presentation.designsystem

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.jj.snoozeloo.R

object AppIcons {

    val alarm: ImageVector
        @Composable
        get() = ImageVector.vectorResource(R.drawable.alarm)

    val arrowBack: ImageVector
        @Composable
        get() = Icons.AutoMirrored.Filled.ArrowBack

    val close: ImageVector
        @Composable
        get() = Icons.Default.Close

    val notification: ImageVector
        @Composable
        get() = ImageVector.vectorResource(R.drawable.icon_notification_ring)

    val silent: ImageVector
        @Composable
        get() = ImageVector.vectorResource(R.drawable.icon_notification_silent)

    val add: ImageVector
        @Composable
        get() = Icons.Default.Add

    val roundCheck: ImageVector
        @Composable
        get() = Icons.Default.CheckCircle

    val delete: ImageVector
        @Composable
        get() = Icons.Default.Delete

    val colon: ImageVector
        @Composable
        get() = ImageVector.vectorResource(R.drawable.colon)


}