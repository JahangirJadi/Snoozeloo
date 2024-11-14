package com.jj.snoozeloo.core.presentation.designsystem.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.jj.snoozeloo.core.presentation.designsystem.montserrat

@Composable
fun AppText12(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = MaterialTheme.colorScheme.onSurface,
    textAlign: TextAlign? = null,
    fontWeight: FontWeight?=null
) {

    Text(
        text = text,
        modifier = modifier,
        style = TextStyle(
            fontSize = 12.sp,
            fontFamily = montserrat,
            fontWeight = fontWeight
        ),
        color = color,
        textAlign = textAlign
    )

}

@Preview(showBackground = true)
@Composable
private fun AppText12Preview() {
    AppText12(text = "This is app text 12")
}

@Composable
fun AppText14(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = MaterialTheme.colorScheme.onSurface,
    textAlign: TextAlign? = null,
    fontWeight: FontWeight?=null
) {

    Text(
        text = text,
        modifier = modifier,
        style = TextStyle(
            fontSize = 14.sp,
            fontFamily = montserrat,
            fontWeight = fontWeight
        ),
        color = color,
        textAlign = textAlign
    )

}

@Preview(showBackground = true)
@Composable
private fun AppText14Preview() {
    AppText14(text = "This is app text 14")
}

@Composable
fun AppText16(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = MaterialTheme.colorScheme.onSurface,
    textAlign: TextAlign? = null,
    fontWeight: FontWeight? = null
) {
    Text(
        text = text,
        modifier = modifier,
        style = TextStyle(
            fontSize = 16.sp,
            fontFamily = montserrat,
            fontWeight = fontWeight
        ),
        color = color,
        textAlign = textAlign
    )
}

@Preview(showBackground = true)
@Composable
private fun AppText16Preview() {
    AppText16(text = "This is app text 16")
}

@Composable
fun AppText20(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = MaterialTheme.colorScheme.onSurface,
    textAlign: TextAlign? = null,
    fontWeight: FontWeight?=null
) {
    Text(
        text = text,
        modifier = modifier,
        style = TextStyle(
            fontSize = 20.sp,
            fontFamily = montserrat,
            fontWeight = fontWeight
        ),
        color = color,
        textAlign = textAlign
    )
}

@Preview(showBackground = true)
@Composable
private fun AppText20Preview() {
    AppText20(text = "This is app text 20")
}

@Composable
fun AppText24(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = MaterialTheme.colorScheme.onSurface,
    textAlign: TextAlign? = null,
    fontWeight: FontWeight?=null
) {
    Text(
        text = text,
        modifier = modifier,
        style = TextStyle(
            fontSize = 24.sp,
            fontFamily = montserrat,
            fontWeight = fontWeight
        ),
        color = color,
        textAlign = textAlign
    )
}

@Preview(showBackground = true)
@Composable
private fun AppText24Preview() {
    AppText24(text = "This is app text 24")
}

