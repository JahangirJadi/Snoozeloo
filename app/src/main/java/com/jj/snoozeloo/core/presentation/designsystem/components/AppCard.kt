package com.jj.snoozeloo.core.presentation.designsystem.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AppCard(modifier: Modifier = Modifier,
            content: @Composable () -> Unit) {

    Card(
        modifier=modifier,
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {

        content()
    }

}

@Preview
@Composable
private fun AppCardPreview() {
    AppCard{

    }
}